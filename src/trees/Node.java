package trees;

import lombok.Data;
import lombok.NonNull;

@Data
public class Node {
    @NonNull
    int data;
    Node left;
    Node right;
}
