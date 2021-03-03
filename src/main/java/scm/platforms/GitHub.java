package scm.platforms;

import scm.AbstractSCM;

import java.util.ArrayList;

public class GitHub extends AbstractSCM {

    public GitHub() {
        setBranchList(new ArrayList<>());
    }
}
