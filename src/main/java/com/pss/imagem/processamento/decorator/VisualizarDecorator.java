package com.pss.imagem.processamento.decorator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class VisualizarDecorator extends ImagemDecorator {

    private VisualizarImagemView view;

    public VisualizarDecorator(ImagemComponente imagemComponente) throws InterruptedException {
        super(imagemComponente);
        imagem = imagemComponente.getImagem();
        if (imagem == null) {
            throw new IllegalArgumentException("Imagem nula, informe uma imagem válida");
        }
        view = new VisualizarImagemView();

        view.getLblImagem().setIcon(new ImageIcon(imagem));
        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
        view.pack();
        view.repaint();
        view.setVisible(true);
    }

    @Override
    public BufferedImage getImagem() {
        return imagem;
    }

    @Override
    public ImagemComponente reverter() {
        throw new IllegalArgumentException("A imagem foi exibida, nao e possivel reverter");
    }

}
