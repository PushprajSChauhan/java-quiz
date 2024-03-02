/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author PUSHPRAJ
 */
public class QuizGame extends javax.swing.JFrame implements ActionListener{

    String [] ques={
      "Which company created Java?","In which year was Java created?","What was Java language originally called?","Who is credited with the creation of Java?"  
    };
    
    String [][] options={
        {"Sun Microsystems","Starbucks","Microsoft","Alphabet"},{"1990","2000","1994","1996"},{"Apple","Latte","Oak","Koffing"},{"Steve Jobs","Bill Gates","Ryan Gosling","James Gosling"}
    };
    
    char [] answers={'A','D','C','D'};
    
    char guess;
    char answer;
    int index;
    int correct_guess=0;
    int total_ques=ques.length;
    int result;
    int seconds=10;
    
    JFrame frame=new JFrame();
    JTextField txtField=new JTextField();
    JTextArea txtArea=new JTextArea();
    JButton buttonA=new JButton();
    JButton buttonB=new JButton();
    JButton buttonC=new JButton();
    JButton buttonD=new JButton();
    JLabel ansLabelA=new JLabel();
    JLabel ansLabelB=new JLabel();
    JLabel ansLabelC=new JLabel();
    JLabel ansLabelD=new JLabel();
    JLabel timeLabel=new JLabel();
    JLabel secondsLeft=new JLabel();
    JTextField numberRight=new JTextField();
    JTextField percent=new JTextField();
    
    Timer timer=new Timer(1000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               seconds--;
               secondsLeft.setText(String.valueOf(seconds));
               if(seconds<=0){
                   displayAnswer();
               }
            }
        }
        );
    
    public QuizGame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);
        
        txtField.setBounds(0,0,650,50);
        txtField.setBackground(new Color(25,25,25));
        txtField.setForeground(new Color(25,255,0));
        txtField.setFont(new Font("Ink Free",Font.BOLD,30));
        txtField.setBorder(BorderFactory.createBevelBorder(1));
        txtField.setHorizontalAlignment(JTextField.CENTER);
        txtField.setEditable(false);
        frame.add(txtField);
        
        txtArea.setBounds(0,50,650,50);
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        txtArea.setBackground(new Color(25,25,25));
        txtArea.setForeground(new Color(25,255,0));
        txtArea.setFont(new Font("MV Boli",Font.BOLD,25));
        txtArea.setBorder(BorderFactory.createBevelBorder(1));
        txtArea.setEditable(false);
        frame.add(txtArea);
        
        buttonA.setBounds(0,100,100,100);
        buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");
        
        buttonB.setBounds(0,200,100,100);
        buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");
        
        buttonC.setBounds(0,300,100,100);
        buttonC.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");
        
        buttonD.setBounds(0,400,100,100);
        buttonD.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");
        
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        
        ansLabelA.setBounds(125,100,500,100);
        ansLabelA.setBackground(new Color(50,50,50));
        ansLabelA.setForeground(new Color(25,255,0));
        ansLabelA.setFont(new Font("MV Boli",Font.PLAIN,35));
        ansLabelB.setBounds(125,200,500,100);
        ansLabelB.setBackground(new Color(50,50,50));
        ansLabelB.setForeground(new Color(25,255,0));
        ansLabelB.setFont(new Font("MV Boli",Font.PLAIN,35));
        ansLabelC.setBounds(125,300,500,100);
        ansLabelC.setBackground(new Color(50,50,50));
        ansLabelC.setForeground(new Color(25,255,0));
        ansLabelC.setFont(new Font("MV Boli",Font.PLAIN,35));
        ansLabelD.setBounds(125,400,500,100);
        ansLabelD.setBackground(new Color(50,50,50));
        ansLabelD.setForeground(new Color(25,255,0));
        ansLabelD.setFont(new Font("MV Boli",Font.PLAIN,35));
        
        frame.add(ansLabelA);
        frame.add(ansLabelB);
        frame.add(ansLabelC);
        frame.add(ansLabelD);
        
        secondsLeft.setBounds(535,510,100,100);
        secondsLeft.setBackground(new Color(25,25,25));
        secondsLeft.setForeground(new Color(255,0,0));
        secondsLeft.setFont(new Font("Ink Free",Font.BOLD,60));
        secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
        secondsLeft.setOpaque(true);
        secondsLeft.setHorizontalAlignment(JTextField.CENTER);
        secondsLeft.setText(String.valueOf(seconds));
        timeLabel.setBounds(535,475,100,25);
        timeLabel.setBackground(new Color(50,50,50));
        timeLabel.setForeground(new Color(255,0,0));
        timeLabel.setFont(new Font("MV Boli",Font.PLAIN,18));
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        
        frame.add(timeLabel);
        frame.add(secondsLeft);
        
        numberRight.setBounds(225,225,200,100);
        numberRight.setBackground(new Color(25,25,25));
        numberRight.setForeground(new Color(25,255,0));
        numberRight.setFont(new Font("Ink Free",Font.BOLD,50));
        numberRight.setBorder(BorderFactory.createBevelBorder(1));
        numberRight.setHorizontalAlignment(JTextField.CENTER);
        numberRight.setEditable(false);
        
        percent.setBounds(225,325,200,100);
        percent.setBackground(new Color(25,25,25));
        percent.setForeground(new Color(25,255,0));
        percent.setFont(new Font("Ink Free",Font.BOLD,50));
        percent.setBorder(BorderFactory.createBevelBorder(1));
        percent.setHorizontalAlignment(JTextField.CENTER);
        percent.setEditable(false);
        
        nextQuestion();
    }
    
    public void nextQuestion(){
        if(index>=total_ques){
            result();
        }else{
            txtField.setText("Question "+(index+1));
            txtArea.setText(ques[index]);
            ansLabelA.setText(options[index][0]);
            ansLabelB.setText(options[index][1]);
            ansLabelC.setText(options[index][2]);
            ansLabelD.setText(options[index][3]);
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        
        if(e.getSource()==buttonA){
            answer='A';
            if(answer==answers[index]){
                correct_guess++;
            }
        }
        else if(e.getSource()==buttonB){
            answer='B';
            if(answer==answers[index]){
                correct_guess++;
            }
        }
        else if(e.getSource()==buttonC){
            answer='C';
            if(answer==answers[index]){
                correct_guess++;
            }
        }
        else{
            answer='D';
            if(answer==answers[index]){
                correct_guess++;
            }
        }
        
        displayAnswer();
    }
    
    public void displayAnswer(){
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        
        if(answers[index]!='A'){
            ansLabelA.setForeground(Color.red);
        }
        if(answers[index]!='B'){
            ansLabelB.setForeground(Color.red);
        }
        if(answers[index]!='C'){
            ansLabelC.setForeground(Color.red);
        }
        if(answers[index]!='D'){
            ansLabelD.setForeground(Color.red);
        }
        
        Timer pause=new Timer(2000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ansLabelA.setForeground(new Color(25,255,0));
                ansLabelB.setForeground(new Color(25,255,0));
                ansLabelC.setForeground(new Color(25,255,0));
                ansLabelD.setForeground(new Color(25,255,0));
                
                answer=' ';
                seconds=10;
                secondsLeft.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        }
        );
        pause.setRepeats(false);
        pause.start();
    }
    
    public void result(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        
        result=(int)((correct_guess/(double)total_ques)*100);
        txtField.setText("RESULTS!");
        txtArea.setText("");
        ansLabelA.setText("");
        ansLabelB.setText("");
        ansLabelC.setText("");
        ansLabelD.setText("");
        
        numberRight.setText("("+correct_guess+"/"+total_ques+")");
        percent.setText(result+"%");
        frame.add(percent);
        frame.add(numberRight);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(QuizGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
