import java.util.List;
/**
 * @author <Nguyen Trung Tin - s3988418>
 */
public class PolicyHolder extends Customer {
    private List<Dependent> dependents;

    public void addDependent(Dependent dependent) {
        dependents.add(dependent);
    }

    public void removeDependent(Dependent dependent) {
        dependents.remove(dependent);
    }

    public List<Dependent> displayDependents() {
        return dependents;
    }

    @Override
    public void displayDetails() {
        // Implement method to display PolicyHolder details
    }
}
