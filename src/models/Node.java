package models;

import lombok.Data;
import lombok.NonNull;

@Data
public class Node {
    @NonNull
    public Integer data;
    public Node left;
    public Node right;
}
