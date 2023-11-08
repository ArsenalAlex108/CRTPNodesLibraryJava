/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package anhkhoapham.treeanditerationlibrary.ReadOnlyTree;

import anhkhoapham.treeanditerationlibrary.Comparision.EqualityComparer;
import anhkhoapham.treeanditerationlibrary.ReadOnlyTree.Operations.TreeIterationOrderer;
import java.util.Collection;
import java.util.Optional;

/**
 * Provides a read-only view over a tree-like data structure. Therefore mutating copy, casting... are not allowed.
 * @author Khoapa
 * @param <T>
 */
public interface ReadOnlyTreeNode<T extends ReadOnlyTreeNode<T>> {   
    
    /**
     * 
     * @return 
     */
    Collection<T> children();
    
    /**
     * Only used when calling print().
     * @return
     */
    default String displayName()
    {
        return toString();
    }
    
    /**
     * Builds an Iterable with the given orderer.
     * @param orderer
     * @return
     */
    Iterable<T> makeIterable(TreeIterationOrderer<T> orderer);
        
    /**
     * 
     * @param other
     * @param comparer
     * @return 
     */
    boolean equals(T other, EqualityComparer<T> comparer);
    
    /**
     * 
     * @param other
     * @return 
     */
    boolean equals(T other);
    
    /**
     * 
     * @param buffer
     * @param prefix
     * @param childrenPrefix 
     */
    default void print(StringBuilder buffer, String prefix, String childrenPrefix)
    {
        ReadOnlyTreeNodeExtensions.print(this, buffer, prefix, childrenPrefix);
    }
    
    default ReadOnlyStringTreeNode ToStringTreeNode()
    {
        return ReadOnlyTreeNodeExtensions.makeStringTreeNode(this);
    }
    
    default Optional<T> parent()
    {
        return Optional.empty();
    }
}
