package structuralcode;

public class Verifications  {
    UIActions uiActions = new UIActions();
    public boolean verifyPageTitle(String exp_Title) {
        String actual_Title = uiActions.getPageTitle();

        if (actual_Title.equals(exp_Title)) {

            System.out.println("Expected title and actual title  Matched");
            return true;
        }else {
            System.out.println("Expected title and actual title Mismatched");
            return false;
        }
    }
}
