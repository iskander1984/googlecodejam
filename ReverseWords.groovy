/**
Problem

Given a list of space separated words, reverse the order of the words. Each line of text contains L letters and W words. A line will only consist of letters and space characters. There will be exactly one space character between each pair of consecutive words.

Input

The first line of input gives the number of cases, N.
N test cases follow. For each test case there will a line of letters and space characters indicating a list of space separated words. Spaces will not appear at the start or end of a line.
*/
def inFile = new File(new File(getClass().protectionDomain.codeSource.location.path).parent + File.separatorChar + 'B-large-practice.in')
resultsFile = new File(new File(getClass().protectionDomain.codeSource.location.path).parent + File.separatorChar +'B-large-practice.out')
resultsFile.delete()
def reverseWords(sentence){
    def words = sentence =~ /\b\w+\b/
    foundWords = words.collect{it}
    foundWords.reverse().eachWithIndex{ it, index->
        if (index == foundWords.size()) resultFile.append(it)
        else resultsFile.append(it + " ")
    }
    resultsFile.append('\n\n')
}
def fileLines = inFile.readLines()
testCaseCount = Integer.parseInt(fileLines[0])
resultsFile.append("Number of test cases:" + testCaseCount + '\n')
for (int i = 0; i < testCaseCount; i++){
		reverseWords(fileLines[i+1])
}