/***
/* simple drawing applet
/* 
/*				Tmax Soft. Woojin, Kim 				
/*
/* Copyright (c) 2000 Tmax Soft.  All rights reserved.
/*														*/

package applet;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class DrawAppletOne extends JApplet implements ActionListener
{
	public void init()
	{
		statusPanel = new JPanel();					
		
		ButtonGroup group = new ButtonGroup();		
		circleButton = addRadioButton(statusPanel, group, "Circle", true);
		triangleButton = addRadioButton(statusPanel, group, "Triangle", false);
		rectangleButton = addRadioButton(statusPanel, group, "Rectangle", false);
		
		eraseButton = new JButton("Erase");			
		statusPanel.add(eraseButton);
		eraseButton.addActionListener(this);
		
		getContentPane().add(statusPanel, "South");		
		
		insertDrawPanel();							
	}												
													
	protected void insertDrawPanel()
	{
		panel = new DrawPanel();							
		getContentPane().add(panel, "Center");
		panel.setOrder(DrawPanel.CIRCLE);
	}

	public JRadioButton addRadioButton(JPanel statusPanel, ButtonGroup g, String buttonName, boolean v)
	{
		JRadioButton button = new JRadioButton(buttonName, v);
		button.addActionListener(this);
		g.add(button);
		statusPanel.add(button);
		return button;
	}
	
	public void actionPerformed(ActionEvent evt)			
	{
		Object source = evt.getSource();
		if (source == circleButton)
			panel.setOrder(DrawPanel.CIRCLE);
		else if (source == triangleButton)
			panel.setOrder(DrawPanel.TRIANGLE);
		else if (source == rectangleButton)
			panel.setOrder(DrawPanel.RECTANGLE);
		else if (source == eraseButton)
			panel.setOrder(DrawPanel.ERASE);
	}
	
	protected JPanel statusPanel;							
	protected DrawPanel panel;
	protected JRadioButton circleButton;
	protected JRadioButton triangleButton;
	protected JRadioButton rectangleButton;
	protected JButton eraseButton;
}


class DrawPanel extends JPanel implements MouseMotionListener, MouseListener
{
	public DrawPanel()
	{
		addMouseMotionListener(this);
		addMouseListener(this);
		step = 0;
		pPoint = new Point[3];
		start = false;
	}
	
	public void setOrder(int order)				
	{
		if (order != 0 && order != shape)
		{
			if (step == 2 && shape == TRIANGLE)	
				repaint();
			shape = order;
		}
		else if (order == ERASE)
			erase();
		else if (order == REPAINT)
			repaint();

		step = 0;
	}
	
	public void erase()							
	{
		buffered_image.flush();
		Dimension d = getSize();
		buffered_image = createImage(d.width, d.height);	
		step = 0;
		repaint();
	}
			
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (start == true)
		{
			g.drawImage(buffered_image, 0, 0, null);		
			
			if (shape == TRIANGLE && step == 2)
			{
				g.drawLine(pPoint[0].x, pPoint[0].y, pPoint[1].x, pPoint[1].y);		
				g.drawLine(pPoint[1].x, pPoint[1].y, pPoint[2].x, pPoint[2].y);
			}
		}
		else												
		{
			Dimension d = getSize();
			buffered_image = createImage(d.width, d.height);
			start = true;
		}
	}
	
	Point[] returnOrdinate(Point first, Point second)		
	{														
		Point[] temp = new Point[2];
		
		temp[0] = (Point)first.clone();
		temp[1] = (Point)second.clone();
		
		if (first.x > second.x)
		{
			temp[0].x = second.x;
			temp[1].x = first.x;
		}
		
		if (first.y > second.y)
		{
			temp[0].y = second.y;
			temp[1].y = first.y;
		}
		
		return temp;
	}
	
	public void mousePressed(MouseEvent evt)
	{
		pPoint[step] = new Point(evt.getX(), evt.getY());
		step++;													
		pPoint[step] = pPoint[step-1];
	}
			
	public void mouseReleased(MouseEvent evt)
	{
		Graphics g = buffered_image.getGraphics();			
															
		switch (shape)
		{
			case TRIANGLE:
				if (step < 3)
				{
					pPoint[step] = pPoint[step-1];

					g = getGraphics();						
					g.drawLine(pPoint[step-1].x, pPoint[step-1].y, pPoint[step].x, pPoint[step].y);
					g.dispose();
				}
				else
				{
					g.drawLine(pPoint[0].x, pPoint[0].y, pPoint[1].x, pPoint[1].y);		
					g.drawLine(pPoint[1].x, pPoint[1].y, pPoint[2].x, pPoint[2].y);
					g.drawLine(pPoint[2].x, pPoint[2].y, pPoint[0].x, pPoint[0].y);
					g.dispose();
					
					g = getGraphics();										
					g.drawLine(pPoint[2].x, pPoint[2].y, pPoint[0].x, pPoint[0].y);		
					g.dispose();
					step = 0;
				}
				break;
			case RECTANGLE:
				g.drawRect(pPoint[step-1].x, pPoint[step-1].y, pPoint[step].x - pPoint[step-1].x, pPoint[step].y - pPoint[step-1].y);
				step = 0;
				break;
			case CIRCLE:
				g.drawOval(pPoint[step-1].x, pPoint[step-1].y, pPoint[step].x - pPoint[step-1].x, pPoint[step].y - pPoint[step-1].y);
				step = 0;
				break;
		}
	}
	
	public void mouseDragged(MouseEvent evt)						
	{
		Point[] temp;
		Graphics g = getGraphics();
		g.setXORMode(getBackground());

		switch (shape)
		{
			case TRIANGLE:
				if (step == 1)
					step++;
					
				g.drawLine(pPoint[step-2].x, pPoint[step-2].y, pPoint[step-1].x, pPoint[step-1].y);
				pPoint[step-1] = new Point(evt.getX(), evt.getY());
				g.drawLine(pPoint[step-2].x, pPoint[step-2].y, pPoint[step-1].x, pPoint[step-1].y);
				g.dispose();
				break;

			case RECTANGLE:
				temp = returnOrdinate(pPoint[step-1], pPoint[step]);
				g.drawRect(temp[0].x, temp[0].y, temp[1].x - temp[0].x, temp[1].y - temp[0].y);

				pPoint[step] = new Point(evt.getX(), evt.getY());

				temp = returnOrdinate(pPoint[step-1], pPoint[step]);
				g.drawRect(temp[0].x, temp[0].y, temp[1].x - temp[0].x, temp[1].y - temp[0].y);

				g.dispose();
				break;

			case CIRCLE:
				temp = returnOrdinate(pPoint[step-1], pPoint[step]);
				g.drawOval(temp[0].x, temp[0].y, temp[1].x - temp[0].x, temp[1].y - temp[0].y);

				pPoint[step] = new Point(evt.getX(), evt.getY());

				temp = returnOrdinate(pPoint[step-1], pPoint[step]);
				g.drawOval(temp[0].x, temp[0].y, temp[1].x - temp[0].x, temp[1].y - temp[0].y);

				g.dispose();
				break;
		}
	}

	public void mouseMoved(MouseEvent evt) 
	{
		if (shape == TRIANGLE)						
		{
			Graphics g = getGraphics();
			g.setXORMode(getBackground());
			g.drawLine(pPoint[step-1].x, pPoint[step-1].y, pPoint[step].x, pPoint[step].y);
			pPoint[step] = new Point(evt.getX(), evt.getY());
			g.drawLine(pPoint[step-1].x, pPoint[step-1].y, pPoint[step].x, pPoint[step].y);
			g.dispose();
		}
	}

	public void mouseClicked(MouseEvent evt) {}	
	public void mouseEntered(MouseEvent evt) {}
	public void mouseExited(MouseEvent evt) {}

	
	
	private Image buffered_image;
	private int shape;			
	private int step;			
	private Point[] pPoint;		
	private boolean start;

	public static final int ERASE = 0;
	public static final int CIRCLE = 1;
	public static final int TRIANGLE = 2;
	public static final int RECTANGLE = 3;
	
	public static final int REPAINT = -1;
}
