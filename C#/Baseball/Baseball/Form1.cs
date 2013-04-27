using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Baseball
{
    public partial class Form1 : Form
    {
        string[,] scores = new string[2, 10];
        int countet = 0;
        

        public Form1()
        {
            InitializeComponent();
            if (countet >= 9)
            {
                textBox2.Enabled = false;
                textBox1.Enabled = false;
            }
        }

        private void textBox1_KeyDown(object sender, KeyEventArgs e)
        {
           
            textBox1.MaxLength = 2;
            if (e.KeyValue < 48 || e.KeyValue > 57)
            {
                if (e.KeyCode != Keys.Delete && e.KeyCode != Keys.Back)
                {
                    if (e.KeyCode < Keys.NumPad0 || e.KeyCode > Keys.NumPad9)
                    {
                        e.SuppressKeyPress = true;
                        btnGo.PerformClick();
                    }
                }
            }
        }

        private void textBox2_KeyDown(object sender, KeyEventArgs e)
        {
            
            textBox2.MaxLength = 2;
            if (e.KeyValue < 48 || e.KeyValue > 57)
            {
                if (e.KeyCode != Keys.Delete && e.KeyCode != Keys.Back)
                {
                    if (e.KeyCode < Keys.NumPad0 || e.KeyCode > Keys.NumPad9)
                    {
                        e.SuppressKeyPress = true;
                        btnGo.PerformClick();
                    }
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnGo_Click(object sender, EventArgs e)
        {
            if (countet < 9)
            {
                scores[0, countet] = textBox1.Text;
                scores[1, countet] = textBox2.Text;

                lblScores.Text = scores[0, 0] + "  " + scores[0, 1] + "  " + scores[0, 2] + "  " + scores[0, 3] + "  " + scores[0, 4] + "  " + scores[0, 5] + "  " + scores[0, 6] + "  " + scores[0, 7] + "  " + scores[0, 8] + Environment.NewLine + scores[1, 0] + "  " + scores[1, 1] + "  " + scores[1, 2] + "  " + scores[1, 3] + "  " + scores[1, 4] + "  " + scores[1, 5] + "  " + scores[1, 6] + "  " + scores[1, 7] + "  " + scores[1, 8];


                countet++;
            }
            else
            {
                textBox1.Enabled = false;
                textBox2.Enabled = false;
            }
           
        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        


    }
}
