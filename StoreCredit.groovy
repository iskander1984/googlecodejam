/**
**
http://code.google.com/codejam/contest/351101/dashboard#s=p0
Problem A Store credit
Problem

You receive a credit C at a local store and would like to buy two items. You first walk through the store and create a list L of all available items. From this list you would like to buy two items that add up to the entire value of the credit. The solution you provide will consist of the two integers indicating the positions of the items in your list (smaller number first).

Input

The first line of input gives the number of cases, N. N test cases follow. For each test case there will be:

One line containing the value C, the amount of credit you have at the store.
One line containing the value I, the number of items in the store.
One line containing a space separated list of I integers. Each integer P indicates the price of an item in the store.
Each test case will have exactly one solution.
Output

For each test case, output one line containing "Case #x: " followed by the indices of the two items whose price adds up to the store credit. The lower index should be output first.
**/
def inFile = new File(new File(getClass().protectionDomain.codeSource.location.path).parent + File.separatorChar + 'A-large-practice.in')
resultsFile = new File(new File(getClass().protectionDomain.codeSource.location.path).parent + File.separatorChar +'A-large-practice.out')
resultsFile.delete()

def resolve(creditAmount, itemsNumber, prices){
    def firstNumberIndex = prices.findIndexOf {prices.indexOf(creditAmount-it) > 0}
    resultsFile.append("First price index: " + (firstNumberIndex+1) + '\n')
    def secondNumberIndex
    prices.eachWithIndex { it, i -> if (it == creditAmount-prices[firstNumberIndex] && it != firstNumberIndex) secondNumberIndex = i}
    resultsFile.append("Second Price index: " + (secondNumberIndex+1)+ '\n')
}

def fileLines = inFile.readLines()
testCaseCount = Integer.parseInt(fileLines[0])
resultsFile.append("Number of test cases:" + testCaseCount + '\n')
for (int i = 0; i < testCaseCount; i = i +3){
    resultsFile.append("Credit amount: " + fileLines[i+1] + '\n')
    resultsFile.append("Items number: " + fileLines[i+2] + '\n')
    resultsFile.append("List of prices: " + fileLines[i+3] + '\n')
    resolve(Integer.parseInt(fileLines[i+1]), Integer.parseInt(fileLines[i+2]), (fileLines[i+3]).split(" ")*.toInteger())    
}
