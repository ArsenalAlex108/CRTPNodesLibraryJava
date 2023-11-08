/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anhkhoapham.treeanditerationlibrary.Iterable;

import java.util.Iterator;
import java.util.Collection;
import java.util.function.Supplier;
/**
 *
 * @author Khoapa
 * @param <T>
 */
public final class ChainedIterable<T> implements Iterable<T> {

    public ChainedIterable(Iterable<Iterable<T>> chain, Supplier<Collection<T>> factory)
    {
        if (chain == null) throw new IllegalArgumentException("chain");
        
        var list = factory.get();
        
        for(var chainIterable : chain)
            for(var obj : chainIterable)
                list.add(obj);
        
        iterable = list;
    }
    
    private final Iterable<T> iterable;
    
    @Override
    public Iterator<T> iterator() {
        return iterable.iterator();
    }
    
}
