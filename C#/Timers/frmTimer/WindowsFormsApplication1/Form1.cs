using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        int count = 5;
        public Form1()
        {
            InitializeComponent();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            label1.Text = DateTime.Now.ToLongTimeString();
            label4.Text = DateTime.Now.ToLongDateString();
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            timer1.Start();
            count = 5;
            timer2.Start();
           
        }

        private void timer2_Tick(object sender, EventArgs e)
        {
            Random rand = new Random();
            this.BackColor = Color.FromArgb(rand.Next(0, 255), rand.Next(0,255), rand.Next(0,255));

            label3.Text = count.ToString();
            this.Width = Width + 10;
            this.Height = Height + 10;
            button1.Top = Top + 20;
            count = count - 1;
            if (count < 0)
                timer2.Stop();
            
        }
    }
}
