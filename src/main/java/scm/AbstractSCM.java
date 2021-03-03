package scm;

import java.util.List;

public abstract class AbstractSCM {

    public List<Branch> branchList;

    public void commit(Branch branch, String message) {
        System.out.println("Committed to branch " + branch.getBranchName() + " , message: " + message);
    }

    public void push(Branch branch) {
        System.out.println("Pushed branch " + branch.getBranchName());
    }

    public void pull(Branch branch) {
        System.out.println("Pulled from branch " + branch.getBranchName());
    }

    public void branch(Branch newBranch) {
        System.out.println("Created new branch with branch name: " + newBranch.getBranchName());
        branchList.add(newBranch);
    }

    public void merge(Branch branch1, Branch branch2) {
        System.out.println("Merged " + branch1.getBranchName() + " with " + branch2.getBranchName());
    }

}
