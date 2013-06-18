/*Problem

You are given two vectors v1=(x1,x2,...,xn) and v2=(y1,y2,...,yn). The scalar product of these vectors is a single number, calculated as x1y1+x2y2+...+xnyn.

Suppose you are allowed to permute the coordinates of each vector as you wish. Choose two permutations such that the scalar product of your two new vectors is the smallest possible, and output that minimum scalar product.

Input

The first line of the input file contains integer number T - the number of test cases. For each test case, the first line contains integer number n. The next two lines contain n integers each, giving the coordinates of v1 and v2 respectively.
Output

For each test case, output a line

Case #X: Y
where X is the test case number, starting from 1, and Y is the minimum scalar product of all permutations of the two given vectors.
*/
def home = '/home/oleksandr/projects/home/googlecodejam/minimumscalarproduct'
def home2 = new File(getClass().protectionDomain.codeSource.location.path).parent

def inFile = new File(home + File.separatorChar +'A-large-practice.in')
resultsFile = new File(home + File.separatorChar +'A-large-practice.out')
resultsFile.delete()

def fileLines = inFile.readLines()
testCaseCount = Integer.parseInt(fileLines[0])

(0..testCaseCount -1).each { findMinimumScalarVector(it + 1, Integer.parseInt(fileLines[it*3 + 1]), fileLines[it*3 + 2], fileLines[it*3 + 3]) }

def findMinimumScalarVector(testCounter, l, first, second) {
    def fsa = first.split(" ").sort {Integer.parseInt(it)}
    println(fsa + "\n")
    def ssa = second.split(" ").sort {Integer.parseInt(it)}.reverse()
    println(ssa + "\n")
    def sum = (0..l-1).inject(0L) { result, j -> result + Long.parseLong(fsa[j])*Long.parseLong(ssa[j]) }
    resultsFile.append("Case #" + testCounter + ": " + sum + "\n")
}