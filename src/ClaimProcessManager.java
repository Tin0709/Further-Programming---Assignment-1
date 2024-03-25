import java.util.List;
/**
 * @author <Nguyen Trung Tin - s3988418>
 */
public interface ClaimProcessManager {
    void add(Claim claim);
    void update(Claim claim);
    void delete(String claimId);
    Claim getOne(String claimId);
    List<Claim> getAll();
}
