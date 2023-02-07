package COS;

public class Bank 
{
    int min = 999;
    int max = 9999;
    int ccLength = 5;
    double creditLimit = 2000.00;

    public int getAuthCode(String cc)
    {
        if (isValid(cc))
        {
            int authCode = (int)(Math.random()*(max-min+1)+min);
            return authCode;
        }
       return 0;
    }

    public boolean isValid(String cc) {
        if (cc == null || cc.length() != ccLength )
        {
            return false;
        }
        return true;
    }
}
