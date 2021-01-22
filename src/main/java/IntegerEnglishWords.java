public class IntegerEnglishWords {
    //https://leetcode.com/problems/integer-to-english-words/
    public static void main(String[] args) {
        System.out.println(new IntegerEnglishWords().numberToWords(30));
        StringBuilder sb = new StringBuilder();
        new IntegerEnglishWords().handleHundreds(100, sb);
        //new IntegerEnglishWords().handleHundreds(519, sb);

        System.out.println(sb);

    }

    public String numberToWords(int num) {
        StringBuilder res = new StringBuilder();

        if (num > 999999999) { //1 Billion
            handleHundreds(num / 1000000000, res);
            res.append(" Billion");
            num %= 1000000000; // remainder from Billion
        }
        if ((num / 1000000) > 0) { // Million
            handleHundreds(num / 1000000, res);
            res.append(" Million");
            num %= 1000000;
        }
        if ((num / 1000) > 0) { // Thousand
            handleHundreds(num / 1000, res);
            res.append(" Thousand");
            num %= 1000;
        }
        handleHundreds(num, res);

        return res.toString().trim();
    }

    //519
    private void handleHundreds(int i, StringBuilder sb) {
        if ((i / 100) > 0) {
            sb.append(number(i / 100) + " Hundred");
            i %= 100;
        }
        if (i > 20) {
            sb.append(number((i / 10) * 10));
            if (i % 10 > 0)
                sb.append(number(i % 10));
        } else if (i > 0)
            sb.append(number(i));
    }


    private String number(int i) {
        System.out.println(i);
        switch (i) {
            case 0:
                return " Zero";
            case 1:
                return " One";
            case 2:
                return " Two";
            case 3:
                return " Three";
            case 4:
                return " Four";
            case 5:
                return " Five";
            case 6:
                return " Six";
            case 7:
                return " Seven";
            case 8:
                return " Eight";
            case 9:
                return " Nine";
            case 10:
                return " Ten";
            case 11:
                return " Eleven";
            case 12:
                return " Twelve";
            case 13:
                return " Thirteen";
            case 14:
                return " Fourteen";
            case 15:
                return " Fifteen";
            case 16:
                return " Sixteen";
            case 17:
                return " Seventeen";
            case 18:
                return " Eighteen";
            case 19:
                return " Nineteen";
            case 20:
                return " Twenty";
            case 30:
                return " Thirty";
            case 40:
                return " Forty";
            case 50:
                return " Fifty";
            case 60:
                return " Sixty";
            case 70:
                return " Seventy";
            case 80:
                return " Eighty";
            case 90:
                return " Ninety";
        }
        return "";
    }
}
