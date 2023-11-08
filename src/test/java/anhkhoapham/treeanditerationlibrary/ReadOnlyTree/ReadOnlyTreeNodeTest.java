/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package anhkhoapham.treeanditerationlibrary.ReadOnlyTree;

import anhkhoapham.treeanditerationlibrary.Comparision.EqualityComparer;
import anhkhoapham.treeanditerationlibrary.Iterable.TransformedIterable;
import java.util.LinkedList;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Khoapa
 */
public class ReadOnlyTreeNodeTest {
    
    public final ReadOnlyStringTreeNode instance;
    
    public ReadOnlyTreeNodeTest() {
        
        instance = makeImmutableStringTreeNodeSample();
        
    }
    
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    private static ReadOnlyStringTreeNode makeImmutableStringTreeNodeSample()
    {
        ReadOnlyStringTreeNode two = new ReadOnlyStringTreeNode("2");
        
        ReadOnlyStringTreeNode three = new ReadOnlyStringTreeNode("3");
        
        var oneChildren = new LinkedList<ReadOnlyStringTreeNode>();
        
        oneChildren.add(two);
        
        ReadOnlyStringTreeNode one = new ReadOnlyStringTreeNode("1", oneChildren);
        
        var zeroChildren = new LinkedList<ReadOnlyStringTreeNode>();
        
        zeroChildren.add(one);
        zeroChildren.add(three);
        
        return new ReadOnlyStringTreeNode("0", zeroChildren); 
    }
    
    private static ReadOnlyStringTreeNode makeEquivalentShapeImmutableStringTreeNodeSample()
    {
        ReadOnlyStringTreeNode two = new ReadOnlyStringTreeNode("1");
        
        ReadOnlyStringTreeNode three = new ReadOnlyStringTreeNode("3");
        
        var oneChildren = new LinkedList<ReadOnlyStringTreeNode>();
        
        oneChildren.add(two);
        
        ReadOnlyStringTreeNode one = new ReadOnlyStringTreeNode("2", oneChildren);
        
        var zeroChildren = new LinkedList<ReadOnlyStringTreeNode>();
        
        zeroChildren.add(one);
        zeroChildren.add(three);
        
        return new ReadOnlyStringTreeNode("0", zeroChildren); 
    }
    
    /**
     * Test of makeIterable method, of class ImmutableTreeNode.
     */
    @Test
    public void testMakeIterable() {
        System.out.println("makeIterable");
        
        var iterable = instance.makeIterable((parent, children) -> 
                {
                    var result = new LinkedList<ReadOnlyStringTreeNode>();
                    
                    result.add(parent);
                    
                    for(var childList : children)
                        for(var child : childList)
                            result.add(child);
                    
                    return result;
                });
        
        var result = new TransformedIterable<>(iterable, ReadOnlyStringTreeNode::name, () -> new LinkedList<>());
        
        LinkedList<String> expResult = new LinkedList<>();
        
        expResult.add("0");
        expResult.add("1");
        expResult.add("2");
        expResult.add("3");
        
        assertTrue(ReadOnlyTreeNodeExtensions.compare(expResult, result));
    }

    /**
     * Test of equals method, of class ImmutableTreeNode.
     */
    @Test
    public void testEquals_GenericType_EqualityComparer() {
        System.out.println("equals");
        
        EqualityComparer<ReadOnlyStringTreeNode> nameComparer = (self, other) -> (self.name() == null ? other.name() == null : self.name().equals(other.name()));
              
        ReadOnlyStringTreeNode other = makeImmutableStringTreeNodeSample();       
        
        // Same tree.
        assertTrue(instance.equals(other, nameComparer), "Same tree.");
        
        EqualityComparer<ReadOnlyStringTreeNode> falseComparer = (a, b) -> false;
        
        // Same tree, false lambda.
        assertFalse(instance.equals(other, falseComparer), "Same tree, false lambda.");
        
        ReadOnlyStringTreeNode sameShape = makeEquivalentShapeImmutableStringTreeNodeSample();
                
        // Different tree, same shape.
        assertFalse(instance.equals(sameShape, nameComparer), "Different tree, same shape.");
        
        EqualityComparer<ReadOnlyStringTreeNode> shapeComparer = (a, b) -> true;
        
        // Different tree, same shape with true lambda.
        assertTrue(instance.equals(sameShape, shapeComparer), "Different tree, same shape with true lambda.");
        
        ReadOnlyStringTreeNode falseOther = new ReadOnlyStringTreeNode("0");
        
        // Different tree, different shape.
        assertFalse(instance.equals(falseOther, shapeComparer), "Different tree, different shape.");
    }

    /**
     * Test of equals method, of class ImmutableTreeNode.
     */
    @Test
    public void testEquals_GenericType() {
        System.out.println("equals");
        
        ReadOnlyStringTreeNode other = makeImmutableStringTreeNodeSample();       

        assertTrue(instance.equals(other));
        
        ReadOnlyStringTreeNode falseOther = makeEquivalentShapeImmutableStringTreeNodeSample();
        
        assertFalse(instance.equals(falseOther));
    }

    /**
     * Test of print method, of class ImmutableTreeNode.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        StringBuilder buffer = new StringBuilder();
        
        instance.print(buffer, "prefix", "childrenPrefix");
    }  
}
