/**
Problem

The Latin alphabet contains 26 characters and telephones only have ten digits on the keypad. We would like to make it easier to write a message to your friend using a sequence of keypresses to indicate the desired characters. The letters are mapped onto the digits as shown below. To insert the character B for instance, the program would press 22. In order to insert two characters in sequence from the same key, the user must pause before pressing the key a second time. The space character ' ' should be printed to indicate a pause. For example, 2 2 indicates AA whereas 22 indicates B.
**/

symbolConfig = ['1':'1','a':'2','b':'22','c':'222','2':'2222','d':'3','e':'33','f':'333','3':'3333','g':'4','h':'44','i':'444','4':'4444','j':'5','k':'55','l':'555','5':'5555','m':'6','n':'66','o':'666','6':'6666','p':'7','q':'77','r':'777','s':'7777','7':'77777','t':'8','u':'88','v':'888','8':'8888','w':'9','x':'99','y':'999','z':'9999','9':'99999','0':'00',' ':'0']

def isInOneRange(symbol1, symbol2){
    symbolConfig[symbol1]?.getAt(0) == symbolConfig[symbol2]?.getAt(0)
}

def inFile = new File(new File(getClass().protectionDomain.codeSource.location.path).parent + File.separatorChar + 'C-large-practice.in')
resultsFile = new File(new File(getClass().protectionDomain.codeSource.location.path).parent + File.separatorChar +'C-large-practice.out')
resultsFile.delete()

def fileLines = inFile.readLines()
testCaseCount = Integer.parseInt(fileLines[0])
resultsFile.append("Number of test cases:" + testCaseCount + '\n')

fileLines.each { line -> 
    def previousSymbol = ''
    line.each {
        def result = ''
        if (isInOneRange(previousSymbol, it)){
            result = ' '
        }    
        result += symbolConfig[it]
        previousSymbol = it
        resultsFile.append(result)
    }
    resultsFile.append('\n')
}