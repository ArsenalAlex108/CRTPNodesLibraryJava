/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anhkhoapham.treeanditerationlibrary.ImmutableStacks;

import java.util.Iterator;

/**
 *
 * @author Khoapa
 */
final class ImmutableStackIterator<T> implements Iterator<T> {

    public ImmutableStackIterator(ImmutableStackNode<T> thisNode) {
        this.thisNode = thisNode;
    }

    private ImmutableStackNode<T> thisNode;
    
    @Override
    public boolean hasNext() {
        return thisNode != null;
    }

    @Override
    public T next() {
        var item = thisNode.item();
                
        thisNode = thisNode.nextNode();
        
        return item;
    }

    /**
     * @return the thisNode
     */
    public ImmutableStackNode<T> getThisNode() {
        return thisNode;
    }
}
