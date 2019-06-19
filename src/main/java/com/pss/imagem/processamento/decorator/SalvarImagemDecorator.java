package com.pss.imagem.processamento.decorator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SalvarImagemDecorator extends ImagemDecorator {

    private String nome;

    public SalvarImagemDecorator(ImagemComponente elementoDecorado, String nome) throws InterruptedException {
        super(elementoDecorado);
        this.nome = nome;
    }

    @Override
    public BufferedImage getImagem() {
        return salvarImagem();
    }

    private BufferedImage salvarImagem() {

        try {
            imagem = elementoDecorado.getImagem();

            String caminho = new File("src/main/resources/").getAbsolutePath();

            File arquivo = new File(caminho + "\\" + this.nome);
            ImageIO.write(imagem, "jpg", arquivo);

            return imagem;
        } catch (IOException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public ImagemComponente reverter() {
        throw new IllegalArgumentException("A imagem foi salva, nao e possivel reverter");
    }

}
