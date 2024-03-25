import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author <Nguyen Trung Tin - s3988418>
 */
public class ConcreteClaimProcessManager implements ClaimProcessManager {
    private Map<String, Claim> claimsMap = new HashMap<>();

    @Override
    public void add(Claim claim) {
        claimsMap.put(claim.getId(), claim);
    }

    @Override
    public void update(Claim claim) {
        // Simply re-putting the claim will update the existing entry if it exists.
        claimsMap.put(claim.getId(), claim);
    }

    @Override
    public void delete(String claimId) {
        claimsMap.remove(claimId);
    }

    @Override
    public Claim getOne(String claimId) {
        return claimsMap.get(claimId);
    }

    @Override
    public List<Claim> getAll() {
        return new ArrayList<>(claimsMap.values());
    }
}
