package br.univel.TelaPrincipal;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class BlockPanel extends JPanel {

	
	public BlockPanel() {
		
//		try {
//			image = ImageIO.read(BlockPanel.class
//					.getResourceAsStream("/fundo.jpg"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		
		setOpaque(false);
		setBackground(Color.GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		
		addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				arg0.consume();
			}
			
		});

	
	}

	public BlockPanel(JComponent painelCentral) {

		this();

		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(painelCentral, gbc_panel);
		setVisible(true);


	}
	
	private AlphaComposite alcom = AlphaComposite.getInstance(
			AlphaComposite.SRC_OVER, 0.3f);
	
	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g.create();
		
//		int posH = (getWidth() / 2) - (image.getWidth(null) / 2);
//		int posV = (getHeight() / 2) - (image.getHeight(null) / 2);
		
//		g2.drawImage(image, posH, posV, null);
		
		g2.setColor(getBackground());
		g2.setComposite(alcom);
		g2.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

		for (int i = 0; i < getHeight(); i += 4) {
			g2.drawLine(0, i, getWidth(), i);
		}

		g2.dispose();

		super.paintComponent(g);
	}

}
