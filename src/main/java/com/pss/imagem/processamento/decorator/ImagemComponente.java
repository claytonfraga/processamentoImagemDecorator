package com.pss.imagem.processamento.decorator;

import java.awt.image.BufferedImage;

public abstract class ImagemComponente {

    protected BufferedImage imagem;

    public abstract BufferedImage getImagem();

    public abstract ImagemComponente reverter();

    public final void visualizar() throws InterruptedException {
        VisualizarDecorator visualizador = new VisualizarDecorator(this);
    }
}
