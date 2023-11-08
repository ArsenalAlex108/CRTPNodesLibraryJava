/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anhkhoapham.treeanditerationlibrary.ReadOnlyTree;

import anhkhoapham.treeanditerationlibrary.Comparision.EqualityComparer;
import anhkhoapham.treeanditerationlibrary.ReadOnlyTree.Operations.TreeIterationOrderer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Khoapa
 */
public class ReadOnlyTreeNodeExtensions {
    
    public static <T extends ReadOnlyTreeNode<T>> boolean compare(T self, T other, EqualityComparer<T> comparer)
    {
        if (self.children().size() != other.children().size()) return false;
        if (comparer.compare(self, other) == false) return false;
                
        var otherIterator = other.children().iterator();
              
        for (var child : self.children())
        {
            var otherChild = otherIterator.next();
            
            if (compare(child, otherChild, comparer) == false)
            {
                return false;
            }
        }
            
        return true;
    }
       
    public static <T> boolean compare(Iterable<T> it, Iterable<T> other)
    {
        var iterator = it.iterator();
        var desIterator = other.iterator();
        
        boolean same = true;
        while(iterator.hasNext()){
          if(!desIterator.hasNext() || !iterator.next().equals(desIterator.next())){
            same = false;
            break;
          }
        }
        
        if (desIterator.hasNext()) return false;
        
        return same;
    }
    
    /**
     * https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram-in-java
     * @param <T>
     * @param self
     * @param buffer
     * @param prefix
     * @param childrenPrefix 
     */
    public static <T extends ReadOnlyTreeNode<T>> void print(ReadOnlyTreeNode<T> self, StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(self.displayName());
        buffer.append('\n');
        for (Iterator<T> it = self.children().iterator(); it.hasNext();) {
            ReadOnlyTreeNode<T> next = it.next();
            if (it.hasNext()) {
                next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }    
    
    public static <T extends ReadOnlyTreeNode<T>> void print(String name, Collection<T> children, StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(name);
        buffer.append('\n');
        for (Iterator<T> it = children.iterator(); it.hasNext();) {
            ReadOnlyTreeNode<T> next = it.next();
            if (it.hasNext()) {
                next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }
    
    public static <T extends ReadOnlyTreeNode<T>> Iterable<T> makeIterable(T self, TreeIterationOrderer<T> orderer) {
        var allChildren = new ArrayList<Iterable<T>>();

        for (var child : self.children()) {
            allChildren.add(child.makeIterable(orderer));
        }
        return orderer.order(self, allChildren);
    }
    
    public static <T extends ReadOnlyTreeNode<T>> ReadOnlyStringTreeNode makeStringTreeNode(ReadOnlyTreeNode<T> self) {
        var newChildren = new ArrayList<ReadOnlyStringTreeNode>();

        for (var child : self.children()) {
            newChildren.add(makeStringTreeNode(child));
        }        

        return new ReadOnlyStringTreeNode(self.displayName(), newChildren);
    }
}
