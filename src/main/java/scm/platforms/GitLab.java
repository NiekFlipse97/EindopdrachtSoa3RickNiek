package scm.platforms;

import scm.AbstractSCM;

import java.util.ArrayList;

public class GitLab extends AbstractSCM {

    public GitLab() {
        setBranchList(new ArrayList<>());
    }
}
