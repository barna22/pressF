function runtest([string]$infile, [string]$outfile)
{
    $result = cat $outfile
    $input = cat $infile
    $output = echo $input | java -jar .\proto\ testapp.jar

    $diff = compare $output $result

    if ($diff.Length -eq 0) 
	{
        echo "Test successfully passed"
    } 
	else 
	{
        echo "Test failed"
        echo "Generated output:"
        echo "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
        echo $output
        echo "Pre-written output:"
        echo "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
        echo $result
    }
}

#main

if($args.Count -eq 2) 
{
    runtest $args[0] $args[1]
}
else 
{
    echo "Error! Wrong input."
}

