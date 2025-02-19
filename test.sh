#!/bin/bash

jmm=$(realpath bin/j--)
numrun=0
numpassed=0
tagre='^//\s*[Ii][Nn][Vv][Aa][Ll][Ii][Dd]$'

cd $1

for file in *.java; do
    numrun=$((numrun+1))
    echo "Testing $file"
    top=$(cat $file | head -n 1)
    valid=1
    if [[ "$top" =~ $tagre ]]; then
        valid=0
    fi

    comp=$($jmm $file 2>&1)

    if [ -n "$comp" ]; then
        # compilation failed
        if [ $valid -eq 1 ]; then
            # does not have tag indicating it should fail
            echo "$file failed to compile when it should have succeeded. STDERR:"
            echo "$comp"
            echo
        else
            # has tag indicating it should fail
            numpassed=$((numpassed+1))
        fi
    else
        # compilation succeeds
        jvm=$(java ${file%.java} 2>&1 > /dev/null)
        if [ $valid -eq 1 ]; then
            # does not have tag indicating it should fail
            if [ -n "$jvm" ]; then
                # jvm prints error
                echo "$file encountered a runtime error. STDERR:"
                echo "$jvm"
                echo
            else
                numpassed=$((numpassed+1))
            fi
        else
            # has tag indicating it should fail
            if [ -n "$jvm" ]; then
                # jvm prints error
                numpassed=$((numpassed+1))
            else
                echo "$file succeeded in compiling when tag indicates it should fail."
                echo
            fi
        fi
        rm ${file%.java}'.class'
    fi
done

echo

if [ $numpassed -eq $numrun ]; then
    echo 'All tests passed.'
else
    printf "%d/%d passed.\n" $numpassed $numrun
fi
