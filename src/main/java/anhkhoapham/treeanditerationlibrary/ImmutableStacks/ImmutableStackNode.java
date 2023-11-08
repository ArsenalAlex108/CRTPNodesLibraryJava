/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anhkhoapham.treeanditerationlibrary.ImmutableStacks;

/**
 *
 * @author Khoapa
 */
final record ImmutableStackNode<T>(T item, ImmutableStackNode<T> nextNode) {   
}
