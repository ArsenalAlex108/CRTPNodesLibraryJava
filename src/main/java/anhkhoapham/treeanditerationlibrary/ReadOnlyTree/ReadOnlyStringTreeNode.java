/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anhkhoapham.treeanditerationlibrary.ReadOnlyTree;

import anhkhoapham.treeanditerationlibrary.Comparision.EqualityComparer;
import anhkhoapham.treeanditerationlibrary.ReadOnlyTree.Operations.TreeIterationOrderer;
import java.util.ArrayList;
import java.util.Collection;

/**
 * A simple tree node containing its name as data.
 * @author Khoapa
 */
public record ReadOnlyStringTreeNode(String name, Collection<ReadOnlyStringTreeNode> children) implements ReadOnlyTreeNode<ReadOnlyStringTreeNode> {

    @Override
    public ReadOnlyStringTreeNode ToStringTreeNode() {
        return this;
    }

    public ReadOnlyStringTreeNode(String name) {
        this(name, new ArrayList<>());
    }

    @Override
    public Iterable<ReadOnlyStringTreeNode> makeIterable(TreeIterationOrderer<ReadOnlyStringTreeNode> orderer) {
        return ReadOnlyTreeNodeExtensions.makeIterable(this, orderer);
    }

    @Override
    public boolean equals(ReadOnlyStringTreeNode other, EqualityComparer<ReadOnlyStringTreeNode> comparer) {
        return ReadOnlyTreeNodeExtensions.compare(this, other, comparer);
    }

    @Override
    public boolean equals(ReadOnlyStringTreeNode other) {
        return ReadOnlyTreeNodeExtensions.compare(this, other, (x, y) -> (x.name == null ? y.name == null : x.name.equals(y.name)));
    }

    @Override
    public void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        ReadOnlyTreeNodeExtensions.print(this, buffer, prefix, childrenPrefix);
    }
}
