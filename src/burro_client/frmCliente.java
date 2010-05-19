/*
 * NovoJFrame.java
 *
 * Created on 28 de Setembro de 2007, 12:07 ==> To com fome ...
 * Created by Carlos Leonardo Ramos P—voa on 01/02/10.
 * Copyright HAPAX 2010. All rights reserved.
 *
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program. (GPL_LICENSE.txt) If not, see <http://www.gnu.org/licenses/>
 *
 *
 */

package burro_client;

import com.sun.imageio.plugins.common.ImageUtil;
import com.sun.java.swing.plaf.windows.DesktopProperty;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.*;
import java.lang.*;
import java.text.DecimalFormat;
import java.applet.*;

import java.io.*;
import java.net.*;
import java.util.Calendar;
import java.util.Random;
import java.util.Vector;
import java.util.Date;
import java.awt.Image;
import java.awt.Toolkit;
import burro_client.JChart2D;
import java.awt.Color;
import java.awt.BasicStroke;
import javax.imageio.ImageReader;
import javax.sound.midi.*; // Sounds o Burro vai berrar ...
import javax.swing.DefaultDesktopManager;
import javax.swing.DesktopManager;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Frame;
import java.awt.Label;
import javax.swing.JDesktopPane;

//import javax.sound.sampled;
//import javax.sound.sampled.spi;
//import java.sound.midi.spi;

/**
 * @author  Leonardo Póvoa
 */


public class frmCliente extends javax.swing.JFrame {
//public class frmCliente extends javax.swing.JApplet {
    
    class BurroMidi extends Thread{
        public MidiDevice device;
        public int tipo; // 0==> Brusco:Control-Change // 1==> Suave:Control-Change // 3==> Brusco:Note-On
        public int nota;
        public int canal;
        
        // Controle Suave
        public int inicio;
        public int fim;
        public int inicio2;
        public int fim2;
        public int inicio3;
        public int fim3;
        public int tempo;
        public int canal1;
        public int canal2;
        public int canal3;
        public int passo;
        public int sincronia;
        
        
//*************************************************************************************************
        BurroMidi(){
            
        }
        
//*************************************************************************************************************
        void MidiSuave(MidiDevice device, int inicio, int fim, int inicio2, int fim2, int inicio3, int fim3,
                int tempo, int canal1, int canal2, int canal3, int passo, int sincronia) {
            
            //for (int f=inicio;f>=fim;f=f-passo) {
            if (sincronia==0) {
                if (inicio<fim){
                    for (int f=inicio;f<=fim;f=f+passo) {
                        ShortMessage msg  =   new ShortMessage();
                        
                        //Canal1
                        try {
                            
                            if (canal1!=0) msg.setMessage(ShortMessage.CONTROL_CHANGE,0,canal1,f);
                            
                        } catch (InvalidMidiDataException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
                        try{
                            
                            if (canal1!=0) {device.getReceiver().send(msg,(int)tempo);
                            
                            try {Thread.sleep((int)tempo);} catch(InterruptedException e){} }
                            
                        } catch (MidiUnavailableException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
                    } //for maior1
                    
                } else {
                    for (int f=inicio;f>=fim;f=f-passo) {
                        ShortMessage msg  =   new ShortMessage();
                        
                        //Canal1
                        try {
                            
                            if (canal1!=0) msg.setMessage(ShortMessage.CONTROL_CHANGE,0,canal1,f);
                            
                            
                        } catch (InvalidMidiDataException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
                        try{
                            
                            if (canal1!=0) {device.getReceiver().send(msg,(int)tempo);
                            
                            try {Thread.sleep((int)tempo);} catch(InterruptedException e){} }
                            
                        } catch (MidiUnavailableException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
                    } //for menor1
                    
                } //if Maior 1
                
                
                if (inicio2<fim2){
                    for (int f=inicio2;f<=fim2;f=f+passo) {
                        ShortMessage msg  =   new ShortMessage();
                        
                        //Canal2
                        try {
                            
                            if (canal2!=0) msg.setMessage(ShortMessage.CONTROL_CHANGE,0,canal2,f);
                            
                            
                        } catch (InvalidMidiDataException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
                        try{
                            
                            if (canal2!=0){ device.getReceiver().send(msg,(int)tempo);
                            
                            try {Thread.sleep((int)tempo);} catch(InterruptedException e){} }
                            
                        } catch (MidiUnavailableException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
                    } //for maior1
                    
                } else {
                    for (int f=inicio2;f>=fim2;f=f-passo) {
                        ShortMessage msg  =   new ShortMessage();
                        
                        //Canal2
                        try {
                            
                            if (canal2!=0) msg.setMessage(ShortMessage.CONTROL_CHANGE,0,canal2,f);
                            
                            
                        } catch (InvalidMidiDataException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
                        try{
                            
                            if (canal2!=0) {device.getReceiver().send(msg,(int)tempo);
                            
                            try {Thread.sleep((int)tempo);} catch(InterruptedException e){} }
                            
                        } catch (MidiUnavailableException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
                    } //for menor1
                    
                } //if Maior 2
                
                
                if (inicio3<fim3){
                    for (int f=inicio3;f<=fim3;f=f+passo) {
                        ShortMessage msg  =   new ShortMessage();
                        
                        //Canal3
                        try {
                            
                            if (canal3!=0) msg.setMessage(ShortMessage.CONTROL_CHANGE,0,canal3,f);
                            
                        } catch (InvalidMidiDataException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
                        try{
                            
                            if (canal3!=0){ device.getReceiver().send(msg,(int)tempo);
                            
                            try {Thread.sleep((int)tempo);} catch(InterruptedException e){} }
                            
                        } catch (MidiUnavailableException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
                    } //for maior1
                    
                } else {
                    for (int f=inicio3;f>=fim3;f=f-passo) {
                        ShortMessage msg  =   new ShortMessage();
                        
                        //Canal3
                        try {
                            
                            if (canal3!=0) msg.setMessage(ShortMessage.CONTROL_CHANGE,0,canal3,f);
                            
                            
                        } catch (InvalidMidiDataException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
                        try{
                            
                            if (canal3!=0) {device.getReceiver().send(msg,(int)tempo);
                            
                            try {Thread.sleep((int)tempo);} catch(InterruptedException e){} }
                            
                        } catch (MidiUnavailableException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
                    } //for menor3
                    
                } //if Maior 3
                
            } else {
                
            } //Sincronia 1
            
        }
        
//******************************************************************************
        public void run(){
            // SCC
            if(tipo==1)  MidiSuave(device,inicio,fim, inicio2,  fim2,  inicio3, fim3,
                    tempo,  canal1,  canal2,  canal3,  passo, sincronia);
            
            //BCC
            if(tipo==0) {
                ShortMessage msg  =  new ShortMessage();
                try {
                    // Canal, Nota, Velocidade
                    
                    msg.setMessage(ShortMessage.CONTROL_CHANGE,0,canal,nota);
                    
                } catch (InvalidMidiDataException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
                try{
                    device.getReceiver().send(msg,(int)tempo);
                    
                } catch (MidiUnavailableException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
            } //Tipo ==>0
            
            
            //BNO
            if(tipo==2) {
                ShortMessage msg  =  new ShortMessage();
                try {
                    // Canal, Nota, Velocidade
                    
                    msg.setMessage(ShortMessage.NOTE_ON,canal,nota);
                    
                } catch (InvalidMidiDataException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
                try{
                    device.getReceiver().send(msg,(int)tempo);
                    
                } catch (MidiUnavailableException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
            } //Tipo ==>0
            
            
        } //Run
        
        
        
        
    } // Classe Burro Midi
    
//************************************************************************************************
    
    // CLASS PontoGPS
    
//************************************************************************************************
    class PontoGps {
        
        public  double Lat;
        public  double Long;
        public  double Velocidade;
        public  double Direcao;
        public  double Distancia;
        public  String NMEA;
        private String NMEAS,lats,longs,dirs,vels,dists;
        
        //Construtor do Objeto
//*************************************************************************************************
        PontoGps(){
            Lat=0;
            Long=0;
            Velocidade=0;
            Direcao=0;
            Distancia=0;
        }
        
//-----------------------------------------------------------------------------------------------------------------
        
        
        
//*****************************************************************************************************************
        void EnviaMidi(MidiDevice device){
            int notaD, notaV, notaR, notaDA, notaVA, notaRA, notaBV, notaBD,mes, ano, dia;
            double tempo1= Double.parseDouble(edMTempo.getText());
            double tempo2= Double.parseDouble(edMTempo2.getText());
           
            Date hoje=new Date();
            mes=hoje.getMonth()+1;
            ano=hoje.getYear()+1900;
            dia=hoje.getDate();
            
            if (Direcao==0) tempo1=300;
            
            // Vel e Dis Max ... Escala ...
            if (Velocidade>VelMax) VelMax=Velocidade; if (VelAnterior>VelMax)  VelMax=VelAnterior;
            if (Distancia>DistMax) DistMax=Distancia; if (DisAnterior>DistMax) DistMax=DisAnterior;
            Vm=Vm+Velocidade;
            Dm=Dm+Distancia;
            ++Conti;
            ++ContiM;
            edVel.setText(String.valueOf((int)VelMax));
            edDis.setText(String.valueOf((int)DistMax));
            // Texto
            
            lbBurro.setText("HAPAX -- GPSMIDI -- "+ " Vel:"+String.valueOf((int)Velocidade)+"Km/h   Andando:"+String.valueOf((int)Dm)+"m"+
                    " -- "+dia+"/"+mes+"/"+ano+"--" + hoje.getHours()+":"+hoje.getMinutes()+":"+hoje.getSeconds());
            
            if (Lat==-999)
            {
              // Quebra
                Mostra.setText(Mostra.getText()+"\n"+"QUEBRA");
                Mostra.setCaretPosition(Mostra.getText().length() ); // new URL() failed 
                
            }


            // Calculo da escala MIDI
            if (Direcao<=360) {notaD=(int)Direcao*127/360;} else notaD=0; // Azimute
            if (AngAnterior<=360) {notaDA=(int)AngAnterior*127/360;} else notaDA=0; // Azimute Anterior
            
            // Atual Suave
            notaV=(int)Velocidade*127/(int)VelMax; // Velocidade
            notaR=(int)Distancia*127/(int)DistMax; // Distancia
            
            // Anterior Suave
            notaVA=(int)VelAnterior*127/(int)VelMax;  // Velocidade
            notaRA=(int)DisAnterior*127/(int)DistMax; // Distancia
            
            //Brutos
            //notaBV=(int)Vm/ContiM*127/(int)VelMax; //  Velocidade Média
            //notaBD=(int)Dm/ContiM*127/(int)DistMax; // Distância Média
            
            //Brutos
            notaBV=(int)Velocidade*127/(int)VelMax; //  Velocidade
            notaBD=(int)Distancia*127/(int)DistMax; // Distância
            
            // Envia os Bruto, depois mete devagar ...
            BurroMidi TA = new  BurroMidi();
            BurroMidi TB = new  BurroMidi();
            BurroMidi TC = new  BurroMidi();
            
            BurroMidi TD = new  BurroMidi();
            BurroMidi TE = new  BurroMidi();
            
            // Device
            TA.device=device;
            TB.device=device;
            TC.device=device;
            TD.device=device;
            TE.device=device;
            
            TA.canal1=Canal1; //80    83 ==> teste
            TA.canal2=0;
            TA.canal3=0;
            TA.inicio=notaDA;
            TA.fim=notaD;
            TA.passo=5;
            TA.tempo=(int)tempo2;
            TA.sincronia=0;
            TA.tipo=1;
            
            TB.canal1=0;
            TB.canal2=Canal2; //81     84 ==> teste
            TB.canal3=0;
            TB.inicio2=notaVA;
            TB.fim2=notaV;
            TB.passo=5;
            TB.tempo=(int)tempo2;
            TB.sincronia=0;
            TB.tipo=1;
            
            TC.canal1=0;
            TC.canal2=0;
            TC.canal3=Canal3; //82    83 ==>teste
            TC.inicio3=notaRA;
            TC.fim3=notaR;
            TC.passo=5;
            TC.tempo=(int)tempo2;
            TC.sincronia=0;
            TC.tipo=1;
            
            //Bruto
            TD.tipo=0;
            TD.nota=notaBV;
            TD.canal=Canal4; //83
            
            TE.tipo=2;
            TE.nota=notaBD;
            TE.canal=84; //84    81==>teste
            
            
            // Atualiza as Barras HAPAX MIDIGPS
            jpAngulo.setString(Integer.toString((int)Direcao)+"  graus");
            jpAngulo.setValue((int)Direcao);
            
            jpDistancia.setMaximum((int)DistMax);
            jpDistancia.setString(Integer.toString((int)Distancia)+"  m");
            jpDistancia.setValue((int)Distancia);
            
            jpVelocidade.setMaximum((int)VelMax);
            jpVelocidade.setString(Integer.toString((int)Velocidade)+"  Km/h");
            jpVelocidade.setValue((int)Velocidade);
            
            // Threads Brutos ...
            TD.start();
            //TE.start();
            try {Thread.sleep((int)tempo2);} catch(InterruptedException e){}
            
               
            // Envia as Threads SUAVES ...
            TA.start();
            TB.start();
            TC.start();
            
            AngAnterior=Direcao;
            VelAnterior=Velocidade;
            DisAnterior=Distancia;
            
            // Pega a velocidade e a distancia max das 30 últimas observações ...
            if (Conti==30){
                VelMax=2;
                DistMax=2;
                Conti=0;
                //Mostra.setText(Mostra.getText()+"\nVel:"+Velocidade+"   Max:"+VelMax);
            }
            
            
            try {Thread.sleep((int)tempo1);} catch(InterruptedException e){}
            
        }
        
        
//*****************************************************************************************************************
        void EnviaMidi_old(MidiDevice device){
            // Envia um evento (msg) MIDI
            
            ShortMessage msg  =   new ShortMessage();
            ShortMessage msg2  =  new ShortMessage();
            ShortMessage msg3  =  new ShortMessage();
            ShortMessage msg4  =  new ShortMessage();
            ShortMessage msg5  =  new ShortMessage();
            int nota, nota1, nota2, nota3, nota4;
            int velocidade;
            
            double tempo= Double.parseDouble(edMTempo.getText());
            
            // Calculo da escala MIDI
            if (Direcao<=360) {nota=(int)Direcao*127/360;} else nota=1;
            nota1=(int)Velocidade*127/8; //Velocidade Maxima
            nota2=(int)Distancia*127/30;
            //nota3=(int)Direcao*127/360;
            //nota4=(int)Direcao*127/360;
            
            if (nota1>127) nota1=126;
            if (nota2>127) nota2=126;
            //if (nota3>127) nota1=127;
            //if (nota4>127) nota1=127;
            
            
            //nota=80; //Velocidade do Burro ....???
            
            try {
                // Canal, Nota, Velocidade
                velocidade=nota;
                
                msg.setMessage(ShortMessage.CONTROL_CHANGE,0,80,nota);
                msg2.setMessage(ShortMessage.CONTROL_CHANGE,0,81,nota1);
                msg3.setMessage(ShortMessage.CONTROL_CHANGE,0,82,nota2);
                msg4.setMessage(ShortMessage.CONTROL_CHANGE,0,83,nota);
                msg5.setMessage(ShortMessage.CONTROL_CHANGE,0,84,nota);
                
            } catch (InvalidMidiDataException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
            try{
                
                device.getReceiver().send(msg,(int)tempo);
                device.getReceiver().send(msg2,(int)tempo);
                device.getReceiver().send(msg3,(int)tempo);
                device.getReceiver().send(msg4,(int)tempo);
                device.getReceiver().send(msg5,(int)tempo);
                Mostra.setText(Mostra.getText()+"\nNota: "+nota+"  Angulo: "+Direcao);
                Mostra.setText(Mostra.getText()+"\nNota: "+nota2+"  Dist: "+Distancia);
                Mostra.setText(Mostra.getText()+"\nNota: "+nota1+"  Velo: "+Velocidade);
                Mostra.setCaretPosition(Mostra.getText().length() );
                if (Direcao==0) tempo=355;
                
                try {Thread.sleep((int)tempo);} catch(InterruptedException e){}
                
                
            } catch (MidiUnavailableException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
            
            
            
        }
        
//*************************************************************************************************************
        // Extrai os valores da String do Servidor (Cburro.aspx), armazenada em NMEA
        void MontaValores(){
            // 0;0;-23,3154166666667;-51,1447783333333;0  // Extrai os valores e coloca no objetos
            // Dis;Dir;Lat;Long;Velocidade
            // Quebra de Rota lat=-999.999 long=-999.999 ==> Marca ...
            
            int ind=0;
            NMEAS=NMEA.replace("," , ".");
            
            //1)
            dists=NMEAS.substring(ind,NMEAS.indexOf(";",ind));
            Distancia=Double.valueOf(dists);
            ind=ind+dists.length()+1;
            
            //2)
            dirs=NMEAS.substring(ind,NMEAS.indexOf(";",ind+1));
            Direcao=Double.valueOf(dirs);
            ind=ind+dirs.length()+1;
            
            //3)
            lats=NMEAS.substring(ind,NMEAS.indexOf(";",ind+1));
            Lat=Double.valueOf(lats);
            ind=ind+lats.length()+1;
            
            //4)
            longs=NMEAS.substring(ind,NMEAS.indexOf(";",ind+1));
            Long=Double.valueOf(longs);
            ind=ind+longs.length()+1;
            
            //5)
            vels=NMEAS.substring(ind,NMEAS.length());
            // Transforma de Knots para Km/h
            Velocidade=Double.valueOf(vels)/100*1.15152*1.60934;
            vels=String.valueOf(Velocidade);
            ind=ind+vels.length()+1;
            
        }
        
        
        
    }   //Classe Ponto Gps
    
//****************************************************************************************************
    
    // Mostra os dados do GPS numa Thread
    class CBurro extends Thread {
        
        // Construtor da classe
        CBurro() {
            
        }
        
        // Thread Acessa o CBurro.aspx, pega os dados do servidor!
        //Nome da Thread runner
        public void run(){
            // compute primes larger than minPrime
            // Ler os dados do GPS
            
            while (Thread.currentThread() == runner) {
                pos=Integer.valueOf(edPos.getText()); // Posi‹o do Arquivo
                BurroPost(pos);
                 //Mostra.setText(Mostra.getText()+"\n\nMERDADDDDDD");
                     //Mostra.setCaretPosition(Mostra.getText().length() ); // new URL() failed
                
                try {
                    
                    Long tempo= Long.parseLong(edTempo.getText());
                    //Mostra.setText(Mostra.getText()+"\n\nMERDADDDDDD"+String.valueOf(tempo));
                     //Mostra.setCaretPosition(Mostra.getText().length() ); // new URL() failed
                    
                    Thread.sleep(tempo);
                    
                } catch (InterruptedException e) {
                } // try sleep
                
                
            }// while
            
        }// run()
        
    }
    
//******************************************************************************
//******************************************************************************
    public void BurroPost(int pos) {
        try {
            
            URL loggeo = new URL("http://www.loggeo.net/cburro.aspx?id="+edId.getText()+"&pos="+pos);
            //URL loggeo = new URL("http://loggeo.locaweb.com.br/cburro.aspx?id="+edId.getText()+"&pos="+pos);
            
            URLConnection Cloggeo = loggeo.openConnection();
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                    Cloggeo.getInputStream()));
            
            
            StringBuffer strBuffer = new StringBuffer();
            
            /************* resposta do servidor ******************/
            int ch;
            
            while((ch = in.read()) !=60){
                strBuffer.append( (char) ch );
            }
            in.close();
            
            // Separa as Strings e guarda no Objetos
            try{
                pos=pos+Separa(strBuffer.toString());
                //if (pos!=0) Desenha(); // Desenha os pontos GPS em LOTE !!!
                edPos.setText(Integer.toString(pos));
            } catch(IndexOutOfBoundsException e){}
            
            Mostra.setText(Mostra.getText()+strBuffer.toString()+"\n\n"); //Mostra String de saida na tela
            //Mostra.setCaretPosition(Mostra.getText().length());
                   
            
        } catch (MalformedURLException e) {
            Mostra.setText(Mostra.getText()+"\n\n"+"Erro de Conex‹o no servidor URL");
            Mostra.setCaretPosition(Mostra.getText().length() ); // new URL() failed
            
        } catch (IOException e) {               // openConnection() failed
            Mostra.setText(Mostra.getText()+"\n\n"+"Erro de Conex‹o no servidor II - NET FORA");
            Mostra.setCaretPosition(Mostra.getText().length() );
            
        }
    }
    
//---------------------------------------------------------------------------
    //Imagem do Google Static Maps ...
    public byte[] loadFromURL(String url) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        URL u = new URL(url);
        HttpURLConnection con = (HttpURLConnection) u.openConnection();
        //con.setDoInput(false);
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.connect();
        
        InputStream is = con.getInputStream();
        int r;
        byte[] buffer = new byte[8000];
        while ((r = is.read(buffer)) >= 0) {
            if (r == 0) continue;
            baos.write(buffer, 0, r);
        }
        is.close();
        return baos.toByteArray();
    }
    
//---------------------------------------------------------------------------
    
    //****************************************************************************************************************
// Desenha os pontos GPS Utilizando o JChart2D e Envia Requisição ao GoogleMaps (Static Map)
//****************************************************************************************************************
    void Desenha(){
        
        // Teste de Pontos
        // Acrescenta os Pontos GPS
        PontoGps Ponto;
        double Longi,lat;
        int PGoogle;
        int indice=BurroVector.size();
       // Mostra.setText(Mostra.getText()+" "+indice);
       // Mostra.setCaretPosition(Mostra.getText().length() );
        int[] xData = new int[indice];
        int[] yData = new int[indice];
        
        UrlGoogle="http://maps.google.com/staticmap?path=rgba:0x0000FF80,weight:5";
        int ContMap=0; //55
        PGoogle=Integer.parseInt(edPtGoogle.getText());
        if (PGoogle>80) {PGoogle=80;}
        if (indice<=PGoogle){UrlMapCont=0; finaliza=indice;} else {UrlMapCont=indice-PGoogle; finaliza=indice;}
        
        for (int i = 0; i < indice; i++) {
            Ponto = (PontoGps)BurroVector.get(i);
            //ContMap=0;
            if ((CbMapa.isSelected()==true)&(i>=UrlMapCont)) {
                ContMap=0;
                if (Ponto.Lat!=-999) UrlGoogle=UrlGoogle+"|"+Ponto.lats.substring(0,Ponto.lats.indexOf(".")+5)+","+Ponto.longs.substring(0,Ponto.lats.indexOf(".")+5);
                ContMap=ContMap+1;
                
                if ((ContMap>=49)||(Ponto.Lat==-999)) {
                    ContMap=0;
                    UrlGoogle=UrlGoogle+"&path=rgba:0x0000FF80,weight:5";
                }
                
            }
            
            Longi=Ponto.Long*10000000;
            lat=Ponto.Lat*   10000000;
            //Longi=Longi*(-1);
            //lat=lat*(-1);

            
            // Quebra de Rota
            if (Ponto.Lat==-999) {

                Longi=-999;
                lat=-999;
            }
              

             
            
            xData[i] = (int)(Longi);
            yData[i] = (int)(lat);
        }
        
        
        GPSplt.setData(xData,yData); // Remonta os pontos de Max e Min
        GPSplt.paintAll(GPSplt.getGraphics());
        repaint();       
        
        
        if (CbMapa.isSelected()==true) {
            // Google Static Map, forma Url tem restrição do tamanho da Url
            
            GPSplt.setVisible(false);
            GPSGoogle.setVisible(true);
            UrlGoogle=UrlGoogle+"&zoom="+jSlider1.getValue()+"&size=600x500&key=ABQIAAAANfHaNxB2EEc7ZYvIOCXAohTCRf8s8QHhhExYFAkAHu8ZlJqlqRR7p2SmTf-HSf3XPv6G1SGPptN5QA";
            try {
                
                // Lendo de uma URL e Mostra a Imagem do Mapa ...
                byte[] imageData = loadFromURL(UrlGoogle);
                Image img = Toolkit.getDefaultToolkit().createImage(imageData);
                
                ImageIcon Icon;
                Icon = new ImageIcon(img);
                GPSGoogle.setIcon(Icon);
                
                //UrlGoogle="http://maps.google.com/staticmap?path=rgba:0x0000FF80,weight:5";
                ContMap=0;
                //Mostra.setText(Mostra.getText()+url.toExternalForm());
                
            } catch (IOException e) {Mostra.setText(Mostra.getText()+"\n\n"+"Erro no GoogleMaps: "+e.getMessage()); Mostra.setCaretPosition(Mostra.getText().length() ); }
            
            
        } else {
            GPSplt.setVisible(true); // Desativa o Painel Hapax (Amarelo)
            GPSGoogle.setVisible(false);
        }
    }
    
    
//****************************************************************************************************************
// Desenha os pontos GPS Utilizando o JChart2D
//****************************************************************************************************************
    void iniciaDesenho(){
        
        
        GPSplt.setStroke(new BasicStroke(5f, BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
        GPSplt.setLineColor(new Color(0,28,28));
        //GPSplt.setSize(935,555);
        GPSplt.setSize(983,465);
        GPSplt.setBackground(new Color(255,255,51));
        GPSplt.setLocation(10,34);
        //jPanel1.add(GPSplt);   
        //jPanel1.setSize(600,500);
        getContentPane().add(GPSplt);
        GPSplt.paintAll(GPSplt.getGraphics());
        GPSGoogle.setVisible(false);
               
        
        // Mostrar Figura de Fundo ...
        if (CbMapa.isSelected()==true) {
            Mostra.setText(Mostra.getText()+"\n"+"MapaAtivo");
            Mostra.setCaretPosition(Mostra.getText().length() );
            
        }
                
        repaint();
        
    }
    
//****************************************************************************************************************
// Ler os dispositivos MIDI instalados !!
//****************************************************************************************************************
    void PegaMIDI(){
        // ler os dispositivos MIDIS instalados na máquina, hardware e softwares
        MidiDevice device;
        MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
        for (int i=0; i<infos.length ;i++){
            try {
                device=MidiSystem.getMidiDevice(infos[i]);
                MDevices.add(device);
                cbMidi.addItem(device.getDeviceInfo().getName()+" "+device.getDeviceInfo().getVersion());
                
            } catch (MidiUnavailableException e){}
            
        }
    }
    
//****************************************************************************************************************
// Ler os dispositivos MIDI instalados !!
//****************************************************************************************************************
    void AbreMidi(){
        // Abre o dispositivo MIDI
        
        device = (MidiDevice)MDevices.get(cbMidi.getSelectedIndex());
        
        if (!(device.isOpen())){
            try{
                device.open();
                Mostra.setText(Mostra.getText()+"\nMIDI: "+device.getDeviceInfo().getName()+" esta aberto!!");
            } catch(MidiUnavailableException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
        }
        
    }
    
    
//****************************************************************************************************************
    public int Separa(String Buffer1){
        String NMEA="";
        int ind=1;
        String Lidos="0";
        
        // Extrai a String entre * e *
        while (ind!=-1){
            
            if (Buffer1.indexOf("*")>-1){
                NMEA=Buffer1.substring(ind,Buffer1.indexOf("*",ind+1));
                if (NMEA.indexOf(";")>-1){
                    ind=ind+NMEA.length()+1;
                    //Monta o Ponto
                    PontoGps Ponto=new PontoGps();
                    Ponto.NMEA=NMEA;
                    Ponto.MontaValores();
                    
                    BurroVector.add(Ponto);
                    // Desenha o Ponto ... Ponto a Ponto, não em Lote ...
                    Desenha();
                    edPos.setText(Integer.toString(pos)); // Desenha Ponto por Ponto ...
            
                    Ponto.EnviaMidi(device);
                    
                    // Mostra os valores dos pontos de TESTES ...
                    
                    //Mostra.setText(Mostra.getText()+"Dis: " +Ponto.dists+"\n");
                    //Mostra.setText(Mostra.getText()+"Dir: " +Ponto.dirs+"\n");
                    //Mostra.setText(Mostra.getText()+"Lat: " +Ponto.lats+"\n");
                    //Mostra.setText(Mostra.getText()+"Long: "+Ponto.longs+"\n");
                    //Mostra.setText(Mostra.getText()+"Velo: "+Ponto.vels+"\n\n");
                    //Mostra.setText(Mostra.getText()+"Elementos: "+BurroVector.size()+"\n\n");
                    
                } else {
                    Lidos=NMEA;
                    return Integer.valueOf(Lidos);
                }
                
            } else ind=-1;
            
        }
        return Integer.valueOf(Lidos);
    }
    
//****************************************************************************************************************
    public void Start(){
        
        if (runner==null){
            //Thread para pegar dados do servidor web
            runner = new CBurro();
            runner.start(); }
        
    }
    
    public void Stop(){
        runner=null;
    }
    
//****************************************************************************************************
    /** Creates new form NovoJFrame */
    public frmCliente() {
        
        initComponents();
        // Botao do Note_ON brusco que foi retirado ...
        //jButton9.setVisible(false);
        
        // Inicializa o display de desenho
        //ImageIcon image=new ImageIcon("Hapax4.PNG");
        //setIconImage(image.getImage());
        
        iniciaDesenho();
        // Lista de Dispositivos MIDI
        PegaMIDI();
        
    }
//****************************************************************************************************
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
//Inicia os componentes Visuais
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbBurro = new javax.swing.JLabel();
        canvas1 = new java.awt.Canvas();
        canvas2 = new java.awt.Canvas();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        Mostra = new javax.swing.JTextPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        cbMidi = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JtmInicial = new javax.swing.JTextField();
        jtmFinal = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jpAngulo = new javax.swing.JProgressBar();
        jpDistancia = new javax.swing.JProgressBar();
        jpVelocidade = new javax.swing.JProgressBar();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jLabel3 = new javax.swing.JLabel();
        edTempo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        edPos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        edId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        edDis = new javax.swing.JTextField();
        edVel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        edMTempo = new javax.swing.JTextField();
        edMTempo2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        edPtGoogle = new javax.swing.JTextField();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        CbMapa = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        GPSGoogle = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HAPAX - GPSMIDI Conectado ao Servidor ***");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusTraversalPolicyProvider(true);
        setFocusable(false);
        setForeground(java.awt.Color.white);

        lbBurro.setFont(new java.awt.Font("Tahoma", 1, 14));
        lbBurro.setForeground(new java.awt.Color(255, 0, 51));
        lbBurro.setText("HAPAX GPS MIDI Client - Gerador de Eventos MIDI - GPS");

        canvas1.setBackground(new java.awt.Color(255, 255, 51));
        canvas1.setForeground(java.awt.Color.black);
        canvas1.setVisible(false);

        jInternalFrame2.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jInternalFrame2.setTitle("Server");
        jInternalFrame2.setMinimumSize(new java.awt.Dimension(86, 35));
        jInternalFrame2.setOpaque(true);
        jInternalFrame2.setRequestFocusEnabled(false);
        jInternalFrame2.setVisible(true);

        Mostra.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Mostra.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Mostra.setFocusCycleRoot(false);
        Mostra.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(Mostra);

        org.jdesktop.layout.GroupLayout jInternalFrame2Layout = new org.jdesktop.layout.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
        );

        jInternalFrame1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jInternalFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setResizable(true);
        jInternalFrame1.setTitle("MIDI");
        jInternalFrame1.setLayer(1);
        jInternalFrame1.setVisible(true);
        jInternalFrame1.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                jInternalFrame1InternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
                jInternalFrame1InternalFrameIconified(evt);
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jButton5.setText("SC_A_80");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jButton7.setText("SC_D_82");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        jButton8.setText("BC_V_83");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });

        jButton6.setText("SC_V_81");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        cbMidi.setAutoscrolls(true);
        cbMidi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMidiItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("               Dispositivo MIDI");

        jButton3.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.borderLight"));
        jButton3.setText("TesteMIDI");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel1.setText("Inicial");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel10.setText("Final");

        JtmInicial.setFont(new java.awt.Font("Tahoma", 0, 12));
        JtmInicial.setText("80");
        JtmInicial.setAutoscrolls(false);

        jtmFinal.setFont(new java.awt.Font("Tahoma", 0, 12));
        jtmFinal.setText("83");
        jtmFinal.setAutoscrolls(false);

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton9.setText("Set");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });

        jpAngulo.setBackground(new java.awt.Color(255, 255, 255));
        jpAngulo.setFont(new java.awt.Font("Tahoma", 1, 11));
        jpAngulo.setForeground(new java.awt.Color(153, 255, 0));
        jpAngulo.setMaximum(360);
        jpAngulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpAngulo.setString("0 graus");
        jpAngulo.setStringPainted(true);

        jpDistancia.setBackground(new java.awt.Color(255, 255, 255));
        jpDistancia.setFont(new java.awt.Font("Tahoma", 1, 11));
        jpDistancia.setForeground(new java.awt.Color(0, 102, 255));
        jpDistancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpDistancia.setString("0 m");
        jpDistancia.setStringPainted(true);

        jpVelocidade.setBackground(new java.awt.Color(255, 255, 255));
        jpVelocidade.setFont(new java.awt.Font("Tahoma", 1, 11));
        jpVelocidade.setForeground(new java.awt.Color(255, 0, 51));
        jpVelocidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpVelocidade.setString("0 Km/h");
        jpVelocidade.setStringPainted(true);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel11.setText("A");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel12.setText("D");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel13.setText("V");

        org.jdesktop.layout.GroupLayout jInternalFrame1Layout = new org.jdesktop.layout.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jInternalFrame1Layout.createSequentialGroup()
                .add(jInternalFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jInternalFrame1Layout.createSequentialGroup()
                        .add(17, 17, 17)
                        .add(jInternalFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jInternalFrame1Layout.createSequentialGroup()
                                .add(jInternalFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel1)
                                    .add(jLabel10))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jInternalFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jtmFinal)
                                    .add(JtmInicial, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jButton9))
                            .add(jInternalFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jInternalFrame1Layout.createSequentialGroup()
                                    .add(jpAngulo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 174, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jLabel11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(jInternalFrame1Layout.createSequentialGroup()
                                    .add(jpDistancia, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 174, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jLabel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(jInternalFrame1Layout.createSequentialGroup()
                                    .add(jpVelocidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 174, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jLabel13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(jButton3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                            .add(cbMidi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 208, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jInternalFrame1Layout.createSequentialGroup()
                        .add(27, 27, 27)
                        .add(jInternalFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jInternalFrame1Layout.createSequentialGroup()
                                .add(91, 91, 91)
                                .add(jInternalFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(jButton6)
                                    .add(jButton8)))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                                .add(jInternalFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jButton7)
                                    .add(jButton5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 77, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(91, 91, 91)))))
                .add(18, 18, 18))
            .add(jInternalFrame1Layout.createSequentialGroup()
                .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        jInternalFrame1Layout.linkSize(new java.awt.Component[] {jButton5, jButton6, jButton7, jButton8}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cbMidi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(jInternalFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jInternalFrame1Layout.createSequentialGroup()
                        .add(24, 24, 24)
                        .add(jInternalFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1)
                            .add(JtmInicial, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(15, 15, 15)
                        .add(jInternalFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel10)
                            .add(jtmFinal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jInternalFrame1Layout.createSequentialGroup()
                        .add(35, 35, 35)
                        .add(jButton9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(35, 35, 35)
                .add(jInternalFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton5)
                    .add(jButton6))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jInternalFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton7)
                    .add(jButton8))
                .add(16, 16, 16)
                .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jInternalFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jpAngulo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel11))
                .add(15, 15, 15)
                .add(jInternalFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jpDistancia, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel12))
                .add(14, 14, 14)
                .add(jInternalFrame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jpVelocidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel13))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jInternalFrame3.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jInternalFrame3.setIconifiable(true);
        jInternalFrame3.setResizable(true);
        jInternalFrame3.setTitle("Utilitys");
        jInternalFrame3.setVisible(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13));
        jLabel3.setText("Tempo");

        edTempo.setText("1000");
        edTempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edTempoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13));
        jLabel5.setText("Pos");

        edPos.setText("0");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13));
        jLabel2.setText("ServerId");

        edId.setText("l2.dat");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13));
        jLabel7.setText("Vel. Max.");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13));
        jLabel8.setText("Dis. Max.");

        edDis.setText("5");

        edVel.setText("3");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13));
        jLabel6.setText("Tempo Msg");

        edMTempo.setText("5000");

        edMTempo2.setText("260");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 13));
        jLabel9.setText("Pts");

        edPtGoogle.setText("60");

        jInternalFrame4.setBackground(new java.awt.Color(255, 255, 153));
        jInternalFrame4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 204, 51)));
        jInternalFrame4.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jInternalFrame4.setIconifiable(true);
        jInternalFrame4.setResizable(true);
        jInternalFrame4.setTitle("Comandos");
        jInternalFrame4.setVisible(true);

        jButton1.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("http://www.loggeo.net/tn2.jpg")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jButton1.setBorder(new javax.swing.border.MatteBorder(null));
        jButton1.setDefaultCapable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("http://www.loggeo.net/pause.JPG")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton4.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("http://www.loggeo.net/stop.jpg")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jSlider1.setBackground(javax.swing.UIManager.getDefaults().getColor("ToolBar.dockingForeground"));
        jSlider1.setMaximum(20);
        jSlider1.setMinimum(5);
        jSlider1.setValue(14);

        CbMapa.setBackground(new java.awt.Color(255, 51, 51));
        CbMapa.setFont(new java.awt.Font("Tahoma", 0, 18));
        CbMapa.setForeground(new java.awt.Color(0, 51, 255));
        CbMapa.setText("Mapa");
        CbMapa.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        CbMapa.setMargin(new java.awt.Insets(0, 0, 0, 0));
        CbMapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CbMapaMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jInternalFrame4Layout = new org.jdesktop.layout.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jInternalFrame4Layout.createSequentialGroup()
                .add(jInternalFrame4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jInternalFrame4Layout.createSequentialGroup()
                        .add(8, 8, 8)
                        .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 72, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jButton4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jInternalFrame4Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jSlider1, 0, 0, Short.MAX_VALUE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jInternalFrame4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(CbMapa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jInternalFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jInternalFrame4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jButton2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jButton4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jInternalFrame4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSlider1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(CbMapa))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout jInternalFrame3Layout = new org.jdesktop.layout.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jInternalFrame3Layout.createSequentialGroup()
                .add(8, 8, 8)
                .add(jInternalFrame4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(26, 26, 26)
                .add(jInternalFrame3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jInternalFrame3Layout.createSequentialGroup()
                        .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(edTempo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 88, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(edPos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jInternalFrame3Layout.createSequentialGroup()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(edId)))
                .add(58, 58, 58)
                .add(jInternalFrame3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel7)
                    .add(jLabel8)
                    .add(jLabel6))
                .add(20, 20, 20)
                .add(jInternalFrame3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jInternalFrame3Layout.createSequentialGroup()
                        .add(edVel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(edPtGoogle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jInternalFrame3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, edDis)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jInternalFrame3Layout.createSequentialGroup()
                            .add(edMTempo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 57, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(edMTempo2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 46, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jInternalFrame3Layout.createSequentialGroup()
                .add(jInternalFrame3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jInternalFrame3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jInternalFrame4)
                        .add(jInternalFrame3Layout.createSequentialGroup()
                            .addContainerGap()
                            .add(jInternalFrame3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(edMTempo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jLabel6)
                                .add(edMTempo2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jInternalFrame3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel7)
                                .add(edVel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jLabel9)
                                .add(edPtGoogle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jInternalFrame3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel8)
                                .add(edDis, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(jInternalFrame3Layout.createSequentialGroup()
                        .add(24, 24, 24)
                        .add(jInternalFrame3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel2)
                            .add(edId, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jInternalFrame3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel3)
                            .add(jLabel5)
                            .add(edPos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(edTempo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );

        GPSGoogle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        GPSGoogle.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("http://maps.google.com/staticmap?center=-21.7566133,-41.331430&zoom=15&size=600x500&key=ABQIAAAANfHaNxB2EEc7ZYvIOCXAohTCRf8s8QHhhExYFAkAHu8ZlJqlqRR7p2SmTf-HSf3XPv6G1SGPptN5QA")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        GPSGoogle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        GPSGoogle.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jMenuBar1.setOpaque(false);

        jMenu1.setText("Servidor");

        jMenuItem1.setText("Start");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Resume");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Exibir Janelas");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Performace");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap(42, Short.MAX_VALUE)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(GPSGoogle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 806, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(145, 145, 145)
                        .add(jInternalFrame1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(10, 10, 10))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(jInternalFrame3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jInternalFrame2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(4292, 4292, 4292)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(515, 515, 515)
                        .add(jSeparator3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 598, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(3637, 3637, 3637))
                    .add(layout.createSequentialGroup()
                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(741, 741, 741)
                                .add(canvas1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 922, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(1368, 1368, 1368)
                                .add(canvas2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))))
            .add(layout.createSequentialGroup()
                .add(98, 98, 98)
                .add(lbBurro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 583, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9621, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(4, 4, 4)
                .add(lbBurro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(layout.createSequentialGroup()
                            .add(23, 23, 23)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(layout.createSequentialGroup()
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 393, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(layout.createSequentialGroup()
                                            .add(355, 355, 355)
                                            .add(jSeparator3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(canvas1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 528, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(canvas2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(layout.createSequentialGroup()
                                    .add(25, 25, 25)
                                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(20, 20, 20))
                        .add(layout.createSequentialGroup()
                            .add(jInternalFrame1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)))
                    .add(GPSGoogle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 447, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(14, 14, 14)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jInternalFrame3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jInternalFrame2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8144, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
// TODO adicione seu código de manipulação aqui:
       
   try         
   {            
     jInternalFrame1.setIcon(true);
     //jInternalFrame2.setIcon(false);
     jInternalFrame3.setIcon(true);
     jInternalFrame4.setIcon(true);
     GPSGoogle.setSize(800,400);
     jInternalFrame2.setLocation(951,30);
     
     
   } catch (java.beans.PropertyVetoException e) {}
        
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
// TODO adicione seu código de manipulação 
    
   try         
   {       
     Performace=false;  
     jInternalFrame1.setIcon(false);
     //jInternalFrame2.setIcon(false);
     jInternalFrame3.setIcon(false);
     jInternalFrame4.setIcon(false);
     jInternalFrame1.setDefaultLocale(jInternalFrame1.getDefaultLocale());
     //jInternalFrame2.setDefaultLocale(jInternalFrame1.getDefaultLocale());
     jInternalFrame3.setDefaultLocale(jInternalFrame1.getDefaultLocale());
     jInternalFrame4.setDefaultLocale(jInternalFrame1.getDefaultLocale());
     jInternalFrame1.doLayout();
     //jInternalFrame2.doLayout();
     jInternalFrame3.doLayout();
     jInternalFrame4.doLayout();
     
   } catch (java.beans.PropertyVetoException e) {}

      
      
      
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
      Canal1=(int)Double.parseDouble(JtmInicial.getText());
      Canal2=(int)Double.parseDouble(JtmInicial.getText())+1;
      Canal3=(int)Double.parseDouble(JtmInicial.getText())+2;
      Canal4=(int)Double.parseDouble(jtmFinal.getText());
      jButton5.setText("SC_A_"+Canal1);
      jButton6.setText("SC_V_"+Canal2);
      jButton7.setText("SC_D_"+Canal3);
      jButton8.setText("BC_V_"+Canal4);
        
        
        
    }//GEN-LAST:event_jButton9MouseClicked

    private void jInternalFrame1InternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_jInternalFrame1InternalFrameOpened
// TODO adicione seu código de manipulação aqui:
    }//GEN-LAST:event_jInternalFrame1InternalFrameOpened

    private void jInternalFrame1InternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_jInternalFrame1InternalFrameIconified
// TODO adicione seu código de manipulação aqui:
        
    }//GEN-LAST:event_jInternalFrame1InternalFrameIconified
    
    private void CbMapaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CbMapaMouseClicked
// TODO adicione seu código de manipulação aqui:
        if (CbMapa.isSelected()==true){
            GPSGoogle.setVisible(true);
            GPSplt.setVisible(false);
            Mostra.setText(Mostra.getText()+"\n"+"Mapa Ativo");}
        
        else {
            
            GPSGoogle.setVisible(false);
            GPSplt.setVisible(true);
            Mostra.setText(Mostra.getText()+"\n"+"Mapa Inativo");  }
        
    }//GEN-LAST:event_CbMapaMouseClicked
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO adicione seu código de manipulação aqui:
    }//GEN-LAST:event_jButton1ActionPerformed
        
    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        ShortMessage msg  =   new ShortMessage();
        
        AbreMidi();
        
        try {
            // Canal, Nota, Velocidade
            
            msg.setMessage(ShortMessage.CONTROL_CHANGE,0,Canal4,100);
            
        } catch (InvalidMidiDataException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
        try{
            
            device.getReceiver().send(msg,-1);
            Mostra.setText(Mostra.getText()+"\n"+"Teste "+Canal4);
            //try {Thread.sleep((int)tempo);} catch(InterruptedException e){}
            //device.getReceiver().send(msg,(int)tempo);
            
        } catch (MidiUnavailableException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
        
    }//GEN-LAST:event_jButton8MouseClicked
    
    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        ShortMessage msg  =   new ShortMessage();
        
        AbreMidi();
        
        try {
            // Canal, Nota, Velocidade
            
            msg.setMessage(ShortMessage.CONTROL_CHANGE,0,Canal3,100);
            
        } catch (InvalidMidiDataException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
        try{
            
            device.getReceiver().send(msg,-1);
            Mostra.setText(Mostra.getText()+"\n"+"Teste "+Canal3);
            //try {Thread.sleep((int)tempo);} catch(InterruptedException e){}
            //device.getReceiver().send(msg,(int)tempo);
            
        } catch (MidiUnavailableException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
        
    }//GEN-LAST:event_jButton7MouseClicked
    
    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
// TODO adicione seu código de manipulação aqui:
        // Teste de Som ...
        ShortMessage msg  =   new ShortMessage();
        
        AbreMidi();
        
        try {
            // Canal, Nota, Velocidade
            
            msg.setMessage(ShortMessage.CONTROL_CHANGE,0,Canal2,100);
            
        } catch (InvalidMidiDataException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
        try{
            
            device.getReceiver().send(msg,-1);
            Mostra.setText(Mostra.getText()+"\n"+"Teste "+Canal2);
            //try {Thread.sleep((int)tempo);} catch(InterruptedException e){}
            //device.getReceiver().send(msg,(int)tempo);
            
        } catch (MidiUnavailableException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
        
        
    }//GEN-LAST:event_jButton6MouseClicked
    
    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // Teste de Som ...
        ShortMessage msg  =   new ShortMessage();
        
        AbreMidi();
        
        try {
            // Canal, Nota, Velocidade
            
            msg.setMessage(ShortMessage.CONTROL_CHANGE,0,Canal1,100);
                        
        } catch (InvalidMidiDataException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
        try{
            
            device.getReceiver().send(msg,-1);
            Mostra.setText(Mostra.getText()+"\n"+"Teste "+Canal1);
            //try {Thread.sleep((int)tempo);} catch(InterruptedException e){}
            //device.getReceiver().send(msg,(int)tempo);
            
        } catch (MidiUnavailableException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
        
        
        
    }//GEN-LAST:event_jButton5MouseClicked
    
    private void cbMidiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMidiItemStateChanged
        AbreMidi();
    }//GEN-LAST:event_cbMidiItemStateChanged
    
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // Zera o Burro ...
        
        BurroVector.removeAllElements();
        
        pos=0;
        VelMax=0;
        DistMax=0;
        Dm=0;
        Vm=0;
        Conti=0;
        ContiM=0;
        AngAnterior=0;
        VelAnterior=0;
        DisAnterior=0;
        
        edVel.setText("4");
        edDis.setText("2");
        edPos.setText("0");
        
        int[] xData = new int[1];
        int[] yData = new int[1];
        
        GPSplt.setData(xData,yData); // Remonta os pontos de Max e Min
        GPSplt.paintAll(GPSplt.getGraphics());
        repaint();
        //if (Performace==true) { jInternalFrame2.setLocation(900,30);}
        
        
    }//GEN-LAST:event_jButton4MouseClicked
    
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
// TODO adicione seu código de manipulação aqui: ..
        
        // Teste de Som ...
        
        int vel;
        double tempo= Double.parseDouble(edMTempo.getText());
        double tempo2= Double.parseDouble(edMTempo2.getText());
        
        BurroMidi TA = new  BurroMidi();
        BurroMidi TB = new  BurroMidi();
        BurroMidi TC = new  BurroMidi();
        
        BurroMidi TD = new  BurroMidi();
        BurroMidi TE = new  BurroMidi();
        
        // PontoGps GPSTeste = new PontoGps();
        
        AbreMidi();
        TA.device=device;
        TB.device=device;
        TC.device=device;
        TD.device=device;
        TE.device=device;
        
        TA.canal1=Canal1;
        TA.canal2=0;
        TA.canal3=0;
        TA.inicio=0;
        TA.fim=127;
        TA.passo=3;
        TA.tempo=(int)tempo2;
        TA.sincronia=0;
        TA.tipo=1;
        
        TB.canal1=0;
        TB.canal2=Canal4;
        TB.canal3=0;
        TB.inicio2=0;
        TB.fim2=127;
        TB.passo=3;
        TB.tempo=(int)tempo2;
        TB.sincronia=0;
        TB.tipo=1;
        
        TC.canal1=0;
        TC.canal2=0;
        TC.canal3=Canal3;
        TC.inicio3=120;
        TC.fim3=0;
        TC.passo=3;
        TC.tempo=(int)tempo2;
        TC.sincronia=0;
        TC.tipo=1;
        
        TD.tipo=0;
        TD.nota=100;
        TD.canal=Canal1;
        
        TE.tipo=2;
        TE.nota=100;
        TE.canal=Canal2;
        
        
        TD.start();
        try {Thread.sleep((int)tempo);} catch(InterruptedException e){}
        
        TE.start();
        try {Thread.sleep((int)tempo);} catch(InterruptedException e){}
        
        TA.start();
        // try {Thread.sleep((int)tempo);} catch(InterruptedException e){}
        TB.start();
        // try {Thread.sleep((int)tempo);} catch(InterruptedException e){}
        TC.start();
        //try {Thread.sleep((int)tempo);} catch(InterruptedException e){}
        
        
        //for (int i=1;i<=12;i++) {
        
        //    try {
        // Canal, Nota, Velocidade
        //        vel=i*10;
        //        msg.setMessage(ShortMessage.CONTROL_CHANGE,0,80,vel);
        //        msg2.setMessage(ShortMessage.CONTROL_CHANGE,0,81,vel);
        //       msg3.setMessage(ShortMessage.CONTROL_CHANGE,0,82,vel);
        //      msg4.setMessage(ShortMessage.CONTROL_CHANGE,0,83,vel);
        //     msg5.setMessage(ShortMessage.CONTROL_CHANGE,0,84,vel);
        
        // } catch (InvalidMidiDataException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
        // try{
        //    vel=i*10;
        //     device.getReceiver().send(msg,-1);
        //   device.getReceiver().send(msg2,-1);
        //   device.getReceiver().send(msg3,-1);
        //   device.getReceiver().send(msg4,-1);
        //   device.getReceiver().send(msg5,-1);
        //   Mostra.setText(Mostra.getText()+"\n"+vel);
        //   try {Thread.sleep((int)tempo);} catch(InterruptedException e){}
        //device.getReceiver().send(msg,(int)tempo);
        
        // } catch (MidiUnavailableException e){Mostra.setText(Mostra.getText()+"\nErro: "+e.getMessage());}
        
        
        //}
        
        
    }//GEN-LAST:event_jButton3MouseClicked
    
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
// TODO adicione seu código de manipulação aqui:
        Stop();
    }//GEN-LAST:event_jButton2MouseClicked
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
// TODO adicione seu código de manipulação aqui:
        //Start a Thread para ler os dados no servidor
        VelMax=Double.parseDouble(edVel.getText());
        DistMax=Double.parseDouble(edDis.getText());
        Dm=0;
        Vm=0;
        AngAnterior=0;
        Start();
    }//GEN-LAST:event_jButton1MouseClicked

    private void edTempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edTempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edTempoActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCliente().setVisible(true);
                
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CbMapa;
    private javax.swing.JLabel GPSGoogle;
    private javax.swing.JTextField JtmInicial;
    private javax.swing.JTextPane Mostra;
    private java.awt.Canvas canvas1;
    private java.awt.Canvas canvas2;
    private javax.swing.JComboBox cbMidi;
    private javax.swing.JTextField edDis;
    private javax.swing.JTextField edId;
    private javax.swing.JTextField edMTempo;
    private javax.swing.JTextField edMTempo2;
    private javax.swing.JTextField edPos;
    private javax.swing.JTextField edPtGoogle;
    private javax.swing.JTextField edTempo;
    private javax.swing.JTextField edVel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JProgressBar jpAngulo;
    private javax.swing.JProgressBar jpDistancia;
    private javax.swing.JProgressBar jpVelocidade;
    private javax.swing.JTextField jtmFinal;
    private javax.swing.JLabel lbBurro;
    // End of variables declaration//GEN-END:variables
    
    private CBurro runner; // Thread
    private int pos=0; // Pos de leitura do arquivo no servidor cburro.aspx
    
    // Desenho
    private Vector BurroVector = new Vector(); // Vetor de Pontos lidos do servidor
    private int[] xData = new int[1];
    private int[] yData = new int[1];
    private JChart2D GPSplt    = new JChart2D(JChart2D.LineChart, xData.length, xData, yData," ");
    private String UrlGoogle="";
    private int UrlMapCont=0;
    private int finaliza=0;
    
    // MIDI
    private Vector MDevices = new Vector();
    private MidiDevice device;
    
    // Notas
    private double VelMax;
    private double DistMax;
    private double Dm=0;
    private double Vm=0;
    private int    Conti=0;
    private int    ContiM=0;
    private double AngAnterior=0;
    private double VelAnterior=0;
    private double DisAnterior=0;
    private int Canal1=80;
    private int Canal2=81;
    private int Canal3=82;
    private int Canal4=83;
    private boolean Performace=false;
    // private int    Faixa=1;
    // private int    FaixaAnterior=1;
    
    
    
}

