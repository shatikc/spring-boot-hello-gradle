def lastTag = "ref/tags/1.0.0-release-master-618"

def givenBranchNameDev = "dev/test"
def givenBranchNameFeature = "feature/test"
def givenBranchNameBug = "bug/test"

println(getNewVersion(givenBranchNameBug,lastTag))

def getNewVersion(String branch , String tag){
    def branchN = branch.split("/")
    branchN = branchN[0]
    def numbers = tag.split("/")
    numbers = numbers[2].split("-")
    numbers = numbers[0].split("\\.")
    switch (branchN){
        case "dev":
            numbers[0]=numbers[0].toInteger()+1
            numbers[1]=0
            numbers[2]=0
            break
        case "feature":
            numbers[1]=numbers[1].toInteger()+1
            numbers[2]=0
            break
        case "bug":
            numbers[2]=numbers[2].toInteger()+1
            break
        default:
            numbers = ""
            break
    }
    return numbers[0]+"."+numbers[1]+"."+numbers[2]+"-RELEASE"
}