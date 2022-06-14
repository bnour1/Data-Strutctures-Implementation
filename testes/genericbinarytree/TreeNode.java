package testes.genericbinarytree;

class TreeNode<T extends Comparable<T>> {
    private TreeNode<T> esq;
    private T info;
    private TreeNode<T> dir;

    TreeNode(T valor) {
        this.info = valor;
    }

    void setInfo(T valor) {
        this.info = valor;
    }

    void setEsq(TreeNode<T> novaEsq) {
        this.esq = novaEsq;
    }

    void setDir(TreeNode<T> novaDir) {
        this.dir = novaDir;
    }

    T getInfo() {
        return this.info;
    }

    TreeNode<T> getEsq() {
        return this.esq;
    }

    TreeNode<T> getDir() {
        return this.dir;
    } 

    

    T findNode(T value) {
        if (value.compareTo(this.info) == 0) {
            return this.info;
        } else if (value.compareTo(this.info) < 0) {
            if (this.esq == null) {
                return null;
            } else {
                return this.esq.findNode(value);
            }
        } else {
            if (this.dir == null) {
                return null;
            } else {
                return this.dir.findNode(value);
            }
        }
    }

    public T encontrarMaiorValor() {
        System.out.println(this.getInfo());
        T maior = null;
        
        if(this.dir != null){
            this.dir.encontrarMaiorValor();
        }else{
            maior = this.getInfo();
        }
        return maior;
    }

    void insertNode(T value) {
        if (value.compareTo(this.getInfo()) == 0) {
            System.out.println("Objeto repetido.");
        } else if (value.compareTo(this.getInfo()) < 0) {
            if (this.esq == null) {
                this.esq = new TreeNode<T>(value);
            } else {
                this.esq.insertNode(value);
            }
        } else {
            if (this.dir == null) {
                this.dir = new TreeNode<T>(value);
            } else {
                this.dir.insertNode(value);
            }
        }
    }
}