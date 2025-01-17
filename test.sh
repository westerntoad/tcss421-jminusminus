#!/bin/bash

jmm=$(realpath bin/j--)
numrun=0
numpassed=0

cd $1

for file in *.java; do
    numrun=$((numrun+1))
    echo "Testing $file"
    top=$(cat $file | head -n 1)
    valid=$(expr "$top" != "// INVALID")
    #comperr=$($jmm $file 2>&1)
    comp=$($jmm $file 2>&1)
    #comp="$jmm $file"
    #$comp

    if [ -n "$comp" ]; then
        # compilation failed
        if [ $valid -eq 1 ]; then
            # does not have tag indicating it should fail
            echo "$file failed to compile when it should have succeeded. STDERR:"
            echo "$comp"
        else
            # has tag indicating it should fail
            echo "$file passed test."
            numpassed=$((numpassed+1))
        fi
    else
        # compilation succeeds
        if [ $valid -eq 1 ]; then
            # does not have tag indicating it should fail
            echo "$file passed test."
            numpassed=$((numpassed+1))
        else
            # has tag indicating it should fail
            echo "$file succeeded in compiling when tag indicates it should fail."
        fi
        rm ${file%.java}'.class'
    fi

    #if [ $valid -eq 1 ]; then
    #    echo "Has valid comment"
    #else
    #    echo "Does not have valid comment"
    #fi


    #if [ \($(comperr) -gt 0\) -ne $valid ]; then
    #    numpassed=$((numpassed+1))
    #    echo "$file passed test."
    ##    class=${file%.java}
    #    rm $class'.class'
    #elif [ -n "$comperr" ]; then
    #    echo "$file failed to compile. STDERR:"
    #    echo $comperr
    #else
    #    echo "$file passed when it should have failed."
    #fi
    #echo $jmmout
    #output=$(java $class)
    #echo $output
    #echo "Successfully ran $file"
    echo
done

printf "%d/%d passed.\n" $numpassed $numrun
