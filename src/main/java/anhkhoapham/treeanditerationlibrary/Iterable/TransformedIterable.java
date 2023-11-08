/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anhkhoapham.treeanditerationlibrary.Iterable;

import java.util.Iterator;
import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;


/**
 *
 * @author Khoapa
 * @param <TIn>
 * @param <TOut>
 */
public final class TransformedIterable<TIn, TOut> implements Iterable<TOut> {

    @Override
    public String toString() {
        return newIterable.toString();
    }

    public TransformedIterable(Iterable<TIn> originalIterable, Function<TIn, TOut> transformer, Supplier<Collection<TOut>> factory) {
        
        if (originalIterable == null) throw new IllegalArgumentException("originalIterable");
        if (transformer == null) throw new IllegalArgumentException("transformer");
        if (factory == null) throw new IllegalArgumentException("factory");
        
        var list = factory.get();
        
        for(var obj : originalIterable)
        {
            list.add(transformer.apply(obj));
        }
        
        newIterable = list;
    }
     
    private final Iterable<TOut> newIterable;

    @Override
    public Iterator<TOut> iterator() {
        return newIterable.iterator();
    }   
}
