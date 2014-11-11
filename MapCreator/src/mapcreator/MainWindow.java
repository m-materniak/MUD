package mapcreator;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 * @author Tomek
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        paint(this.getGraphics());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSide = new javax.swing.JTabbedPane();
        pnlMap = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMapName = new javax.swing.JTextField();
        btnSaveToFile = new javax.swing.JButton();
        txtFileName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        btnNewMap = new javax.swing.JButton();
        pnlContainer = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtContainerName = new javax.swing.JTextField();
        btnSaveContainer = new javax.swing.JButton();
        btnEditContainer = new javax.swing.JButton();
        btnRemoveContainer = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstContainer = new javax.swing.JList();
        jLabel9 = new javax.swing.JLabel();
        cobContainerParent = new javax.swing.JComboBox();
        lblNumContainer = new javax.swing.JLabel();
        pnlItem = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtItemName = new javax.swing.JTextField();
        btnSaveItem = new javax.swing.JButton();
        btnEditItem = new javax.swing.JButton();
        btnRemoveItem = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstItem = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        cobItemParent = new javax.swing.JComboBox();
        lblNumItems = new javax.swing.JLabel();
        pnlEnemy = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstEnemy = new javax.swing.JList();
        btnEditEnemy = new javax.swing.JButton();
        btnRemoveEnemy = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtEnemyName = new javax.swing.JTextField();
        btnSaveEnemy = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cobEnemyParent = new javax.swing.JComboBox();
        lblNumEnemies = new javax.swing.JLabel();
        pnlRooms = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstRooms = new javax.swing.JList();
        btnEditRoom = new javax.swing.JButton();
        btnRemoveRoom = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtRoomName = new javax.swing.JTextField();
        btnSaveRoom = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        lblNumRooms = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nazwa mapy:");

        btnSaveToFile.setText("Zapisz");

        txtFileName.setText("map.mm");

        jLabel6.setText("Nazwa pliku:");

        jButton6.setText("Wczytaj");

        btnNewMap.setText("Nowa Mapa");
        btnNewMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewMapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMapLayout = new javax.swing.GroupLayout(pnlMap);
        pnlMap.setLayout(pnlMapLayout);
        pnlMapLayout.setHorizontalGroup(
            pnlMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMapName)
                    .addGroup(pnlMapLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFileName))
                    .addGroup(pnlMapLayout.createSequentialGroup()
                        .addGroup(pnlMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(pnlMapLayout.createSequentialGroup()
                                .addComponent(btnSaveToFile, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMapLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNewMap)))
                .addContainerGap())
        );
        pnlMapLayout.setVerticalGroup(
            pnlMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMapName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNewMap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                .addGroup(pnlMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(8, 8, 8)
                .addGroup(pnlMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveToFile)
                    .addComponent(jButton6))
                .addGap(8, 8, 8))
        );

        pnlSide.addTab("Mapa", pnlMap);

        jLabel5.setText("Nazwa Wroga:");

        btnSaveContainer.setText("Zapisz");

        btnEditContainer.setText("Edytuj");

        btnRemoveContainer.setText("Usuń");

        lstContainer.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(lstContainer);

        jLabel9.setText("Rodzic:");

        lblNumContainer.setText("jLabel10");

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContainerLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(38, 38, 38)
                        .addComponent(cobContainerParent, 0, 94, Short.MAX_VALUE))
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addComponent(lblNumContainer)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlContainerLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addGroup(pnlContainerLayout.createSequentialGroup()
                            .addComponent(btnEditContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnRemoveContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                        .addGroup(pnlContainerLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtContainerName))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContainerLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(btnSaveContainer)))
                    .addContainerGap()))
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cobContainerParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116)
                .addComponent(lblNumContainer)
                .addContainerGap(229, Short.MAX_VALUE))
            .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlContainerLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtContainerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(134, 134, 134)
                    .addComponent(btnSaveContainer)
                    .addGap(0, 0, 0)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditContainer)
                        .addComponent(btnRemoveContainer))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pnlSide.addTab("Kontenery", pnlContainer);

        jLabel4.setText("Nazwa Wroga:");

        btnSaveItem.setText("Zapisz");

        btnEditItem.setText("Edytuj");

        btnRemoveItem.setText("Usuń");

        lstItem.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(lstItem);

        jLabel7.setText("Rodzic:");

        lblNumItems.setText("jLabel10");

        javax.swing.GroupLayout pnlItemLayout = new javax.swing.GroupLayout(pnlItem);
        pnlItem.setLayout(pnlItemLayout);
        pnlItemLayout.setHorizontalGroup(
            pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlItemLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(38, 38, 38)
                        .addComponent(cobItemParent, 0, 94, Short.MAX_VALUE))
                    .addGroup(pnlItemLayout.createSequentialGroup()
                        .addComponent(lblNumItems)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlItemLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addGroup(pnlItemLayout.createSequentialGroup()
                            .addComponent(btnEditItem, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnRemoveItem, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                        .addGroup(pnlItemLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtItemName))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlItemLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(btnSaveItem)))
                    .addContainerGap()))
        );
        pnlItemLayout.setVerticalGroup(
            pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItemLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cobItemParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(115, 115, 115)
                .addComponent(lblNumItems)
                .addContainerGap(232, Short.MAX_VALUE))
            .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlItemLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(134, 134, 134)
                    .addComponent(btnSaveItem)
                    .addGap(0, 0, 0)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditItem)
                        .addComponent(btnRemoveItem))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pnlSide.addTab("Przedmioty", pnlItem);

        lstEnemy.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(lstEnemy);

        btnEditEnemy.setText("Edytuj");

        btnRemoveEnemy.setText("Usuń");

        jLabel3.setText("Nazwa Wroga:");

        btnSaveEnemy.setText("Zapisz");

        jLabel8.setText("Rodzic:");

        lblNumEnemies.setText("jLabel10");

        javax.swing.GroupLayout pnlEnemyLayout = new javax.swing.GroupLayout(pnlEnemy);
        pnlEnemy.setLayout(pnlEnemyLayout);
        pnlEnemyLayout.setHorizontalGroup(
            pnlEnemyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEnemyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEnemyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEnemyLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(38, 38, 38)
                        .addComponent(cobEnemyParent, 0, 94, Short.MAX_VALUE))
                    .addGroup(pnlEnemyLayout.createSequentialGroup()
                        .addComponent(lblNumEnemies)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlEnemyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEnemyLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnlEnemyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addGroup(pnlEnemyLayout.createSequentialGroup()
                            .addComponent(btnEditEnemy, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnRemoveEnemy, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                        .addGroup(pnlEnemyLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtEnemyName))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEnemyLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(btnSaveEnemy)))
                    .addContainerGap()))
        );
        pnlEnemyLayout.setVerticalGroup(
            pnlEnemyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEnemyLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlEnemyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cobEnemyParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112)
                .addComponent(lblNumEnemies)
                .addContainerGap(232, Short.MAX_VALUE))
            .addGroup(pnlEnemyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEnemyLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnlEnemyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtEnemyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(134, 134, 134)
                    .addComponent(btnSaveEnemy)
                    .addGap(0, 0, 0)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnlEnemyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditEnemy)
                        .addComponent(btnRemoveEnemy))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pnlSide.addTab("Wrogowie", pnlEnemy);

        jScrollPane1.setViewportView(lstRooms);

        btnEditRoom.setText("Edytuj");

        btnRemoveRoom.setText("Usuń");

        jLabel2.setText("Nazwa pokoju:");

        btnSaveRoom.setText("Zapisz");

        jButton1.setText("N");

        jButton2.setText("E");

        jButton3.setText("W");

        jButton4.setText("S");

        lblNumRooms.setText("jLabel10");

        javax.swing.GroupLayout pnlRoomsLayout = new javax.swing.GroupLayout(pnlRooms);
        pnlRooms.setLayout(pnlRoomsLayout);
        pnlRoomsLayout.setHorizontalGroup(
            pnlRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoomsLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton3)
                .addGap(0, 0, 0)
                .addGroup(pnlRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jButton1))
                .addGap(0, 0, 0)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlRoomsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnlRoomsLayout.createSequentialGroup()
                        .addComponent(btnEditRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                    .addGroup(pnlRoomsLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRoomName))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRoomsLayout.createSequentialGroup()
                        .addComponent(lblNumRooms)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSaveRoom)))
                .addContainerGap())
        );
        pnlRoomsLayout.setVerticalGroup(
            pnlRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRoomsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRoomsLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(pnlRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addGroup(pnlRoomsLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(pnlRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveRoom)
                    .addComponent(lblNumRooms))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditRoom)
                    .addComponent(btnRemoveRoom))
                .addContainerGap())
        );

        pnlSide.addTab("Pokoje", pnlRooms);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(678, Short.MAX_VALUE)
                .addComponent(pnlSide, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSide)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewMapActionPerformed
        rooms=new ArrayList<>();
        enemies=new ArrayList<>();
        items=new ArrayList<>();
        containers=new ArrayList<>();
        map=new Map();
        map.setName(this.txtMapName.getText());
        Room firstRoom=new Room();
        firstRoom.setName("START");
        firstRoom.setCordX(15);
        firstRoom.setCordY(20);
        map.addRoom(firstRoom);
        rooms.add(firstRoom);
       repaint();
    }//GEN-LAST:event_btnNewMapActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    public void updateRoomsList(Map map){
        DefaultListModel  model = new DefaultListModel();
        lstRooms.setModel(model);
        this.lblNumRooms.setText("Liczba pokoi: "+rooms.size());
        for (int i=0;i< rooms.size();i++){
            String s=Integer.toString(i)+rooms.get(i).getLine();
            model.addElement(s);
        }
    }
    public void updateEnemiesList(Map map){
        DefaultListModel  model = new DefaultListModel();
        lstEnemy.setModel(model);
        this.lblNumEnemies.setText("Liczba wrogów: "+enemies.size());
        for (int i=0;i< rooms.size();i++){
            String s=Integer.toString(i)+rooms.get(i).getLine();
            model.addElement(s);
        }
    }
    
    public void paint(Graphics arg0) {
       super.paint(arg0);
       int recSize=16;
       int start=20;
       //rysowanie planszy
       for(int i=0;i<30;i++){
           for(int j=0;j<40;j++){
               arg0.setColor(Color.GRAY);
               arg0.fillRect(start+recSize*j,2*start+ recSize*i,recSize-1, recSize-1);
               arg0.setColor(Color.black);
               arg0.drawRect(start+recSize*j,2*start+recSize*i,recSize-1, recSize-1);
           }
       }
       //rysowanie pokoi
       if(map!=null){
           int i=0;
           while(map.getRoom(i)!=null){
               Room room=map.getRoom(i);
               int x=room.getCordX();
               int y=room.getCordY();
               arg0.setColor(room.getColor());
               arg0.fillRect(start+recSize*y,2*start+ recSize*x,recSize-1, recSize-1);
               i++;
           }
           
       }
       
                    
    }
    public Map map;
    public ArrayList<Room> rooms;
    public ArrayList<Room> enemies;
    public ArrayList<Room> items;
    public ArrayList<Room> containers;
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditContainer;
    private javax.swing.JButton btnEditEnemy;
    private javax.swing.JButton btnEditItem;
    private javax.swing.JButton btnEditRoom;
    private javax.swing.JButton btnNewMap;
    private javax.swing.JButton btnRemoveContainer;
    private javax.swing.JButton btnRemoveEnemy;
    private javax.swing.JButton btnRemoveItem;
    private javax.swing.JButton btnRemoveRoom;
    private javax.swing.JButton btnSaveContainer;
    private javax.swing.JButton btnSaveEnemy;
    private javax.swing.JButton btnSaveItem;
    private javax.swing.JButton btnSaveRoom;
    private javax.swing.JButton btnSaveToFile;
    private javax.swing.JComboBox cobContainerParent;
    private javax.swing.JComboBox cobEnemyParent;
    private javax.swing.JComboBox cobItemParent;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblNumContainer;
    private javax.swing.JLabel lblNumEnemies;
    private javax.swing.JLabel lblNumItems;
    private javax.swing.JLabel lblNumRooms;
    private javax.swing.JList lstContainer;
    private javax.swing.JList lstEnemy;
    private javax.swing.JList lstItem;
    private javax.swing.JList lstRooms;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlEnemy;
    private javax.swing.JPanel pnlItem;
    private javax.swing.JPanel pnlMap;
    private javax.swing.JPanel pnlRooms;
    private javax.swing.JTabbedPane pnlSide;
    private javax.swing.JTextField txtContainerName;
    private javax.swing.JTextField txtEnemyName;
    private javax.swing.JTextField txtFileName;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtMapName;
    private javax.swing.JTextField txtRoomName;
    // End of variables declaration//GEN-END:variables
}
