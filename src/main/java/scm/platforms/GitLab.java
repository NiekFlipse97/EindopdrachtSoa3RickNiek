package scm.platforms;

import scm.AbstractSCM;
import scm.Branch;

import java.util.ArrayList;

public class GitLab extends AbstractSCM {

    public GitLab() {
        this.branchList = new ArrayList<>();
    }
}
