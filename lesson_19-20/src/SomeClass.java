public class SomeClass implements Inter{
    @Override
    public String returnShortWord(String oneWord, String twoWord) {
        String res;
        res = oneWord.length() <= twoWord.length() ? oneWord : twoWord;
        return res;
    }
}
