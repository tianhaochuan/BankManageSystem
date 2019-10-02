package CoursreDesign;

public class one {
    /**
     * 二叉树
     *
     * @param <T>
     */
    static class Tree<T> {
        public class Entry { //树的节点类
            T data;
            Entry left;
            Entry right;

            public Entry(T data) {
                this.data = data;
                this.left = null;
                this.right = null;
            }
        }

        private Entry root = null;  //根节点

        /**
         * 设置父节点
         *
         * @param data
         */
        public void setRoot(T data) {
            this.root = new Entry(data);
        }

        /**
         * 获取父节点
         *
         * @return
         */
        public Entry getRoot() {
            return root;
        }

        /**
         * 添加节点
         *
         * @param value       要添加的节点的值
         * @param index       添加在父节点的左(0)或右（1）
         * @param father_data 要添加的节点的父节点
         */
        public void add(T value, int index, T father_data) {
            if (root == null) {
                System.out.println("请先设置根节点！");
                return;
            }
            Entry dad = find_father_node(root, father_data);
            if (dad == null) {
                System.out.println("不存在该节点！！！");
                return;
            }
            if (index == 0) {
                if (dad.left == null) {
                    dad.left = new Entry(value);
                } else {
                    System.out.println("此节点已被占用");
                }
            } else {
                if (dad.right == null) {
                    dad.right = new Entry(value);
                } else {
                    System.out.println("此节点已被占用");
                }
            }
        }

        /**
         * 寻找当前要添加节点的父节点
         *
         * @param root
         * @param father_data
         * @return
         */
        private Entry find_father_node(Entry root, T father_data) {
            Entry ptr;
            if (root == null) {
                return null;
            }
            if (root.data == father_data) {
                return root;
            } else {
                if ((ptr = find_father_node(root.left, father_data)) != null) {
                    return ptr;
                } else if ((ptr = find_father_node(root.right, father_data)) != null) {
                    return ptr;
                } else {
                    return null;
                }
            }
        }


        /**
         * 先序遍历树
         *
         * @param node
         */
        public void DLR(Entry node) {
            if (node != null) {
                show(node);
                DLR(node.left);
                DLR(node.right);
            }
        }


        /**
         * 中序遍历树
         *
         * @param node
         */
        public void LDR(Entry node) {
            if (node != null) {
                LDR(node.left);
                show(node);
                LDR(node.right);
            }
        }

        /**
         * 打印节点数据
         *
         * @param node
         */
        private void show(Entry node) {
            System.out.print(node.data + "\t");
        }

        /**
         * 获得树的深度
         *
         * @param node
         * @return
         */
        public int getLength(Entry node) {
            int depleft, depright;
            if (node == null) {
                return 0;
            } else {
                depleft = getLength(node.left);
                depright = getLength(node.right);
                if (depleft > depright) {
                    return depleft + 1;
                } else {
                    return depright + 1;
                }
            }
        }
    }
    public static void main(String[] args) {
        Tree<String> tree = new Tree<>();
        tree.setRoot("A");
        tree.add("B",0,"A");
        tree.add("C",1,"A");
        tree.add("D",0,"B");
        tree.add("E",0,"C");
        tree.add("F",1,"C");
        tree.add("G",0,"D");
        tree.add("H",1,"D");
        tree.add("I",0,"E");
        tree.add("K",0,"F");
        tree.DLR(tree.getRoot());
        System.out.println();
        tree.LDR(tree.getRoot());
        System.out.println("\n树的深度"+tree.getLength(tree.getRoot()));
    }
}