package com.example;

import java.util.NoSuchElementException;

public class ListaEncadeadaSimples<T> {
    private static class No<T> {
        private T valor;
        private No<T> proximo;
        private No(T valor) {
            this.valor = valor; 
        }
    }
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    private No<T> head;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public void addFirst(T valor) {
        No<T> novo = new No<>(valor);
        novo.proximo = head;
        head = novo;
        size++;
    }
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public void addLast(T valor) {
        No<T> novo = new No<>(valor);
        if (head == null) {
            head = novo;
            size++;
            return;
        }
        No<T> atual = head;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }
        atual.proximo = novo;
        size++;
    }
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public boolean contains(T valor) {
        No<T> atual = head;
        while (atual != null) {
            if ((valor != null && atual.valor == null)
                || (valor != null && valor.equals(atual.valor))) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    private void validarIndice(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Indice: " + index + " fora do intervalo [0, " + (size - 1) + "]");
        }
    }

    public T get(int index) {
        validarIndice(index);
        No<T> atual = head;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }
        return atual.valor;
    }
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public T removerFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vazia");
        }
        T removido = head.valor;
        head = head.proximo;
        size--;
        return removido;
    }
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vazia");
        }
        if (head.proximo == null) {
            T removido = head.valor;
            head = null;
            size--;
            return removido;
        }
        No<T> atual = head;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }
        T removido = atual.proximo.valor;
        atual.proximo = null;
        size--;
        return removido;
    }
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public boolean removeValue(T valor) {
        if (isEmpty()) {
            return false;
        }
        if ((valor != null && head.valor == null)
            || (valor != null && valor.equals(head.valor))) {
            head = head.proximo;
            size--;
            return true;
        }
        No<T> atual = head;
        while (atual.proximo != null) {
            boolean encontrou = (valor == null && atual.proximo.valor == null)
                || (valor != null && valor.equals(atual.proximo.valor));
            if (encontrou) {
                atual.proximo = atual.proximo.proximo;
                size--;
                return true;
            }
            atual = atual.proximo;
        }
            return false;
    }
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public String toString() {
        StringBuilder sb = new StringBuilder();
        No<T> atual = head;
        while (atual != null) {
            sb.append(atual.valor);
            if (atual.proximo != null) {
                sb.append(" -> ");
            }
            atual = atual.proximo;
        }
        sb.append("]");
        return sb.toString();
    }
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

}
