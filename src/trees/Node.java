package trees;

import lombok.Data;
import lombok.NonNull;

@Data
public class Node {
    @NonNull
    Integer data;
    Node left;
    Node right;
}
