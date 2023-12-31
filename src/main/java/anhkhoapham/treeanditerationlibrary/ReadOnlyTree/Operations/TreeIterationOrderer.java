/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package anhkhoapham.treeanditerationlibrary.ReadOnlyTree.Operations;

/**
 *
 * @author Khoapa
 * @param <T>
 */
public interface TreeIterationOrderer<T> {
    
    /**
     *
     * @param parent is parent node
     * @param children an Iterable contains Iterables generated by each children. 
     * @return
     */
    Iterable<T> order(T parent, Iterable<Iterable<T>> children);
    
}
