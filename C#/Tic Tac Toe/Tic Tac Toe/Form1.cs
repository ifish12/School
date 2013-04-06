using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Tic_Tac_Toe
{
    public partial class frmTac : Form
    {
        char CurrentPlayer = 'X';
        char Player1 = 'X';
        char Player2 = 'O';
        int counter = 0;

        public frmTac()
        {
            InitializeComponent();
            Clear();
        }

        private void Winner()
        {
            

                //Top row
                if (lblTL.Text == lblTM.Text && lblTM.Text == lblTR.Text && lblTL.Text != " ")
                {
                    MessageBox.Show("There is a winner!");
                    Clear();
                }

                // Middle row
                else if (lblML.Text == lblMM.Text && lblMM.Text == lblMR.Text && lblML.Text != " ")
                {
                    MessageBox.Show("There is a winner!");
                    Clear();
                }

                // Bottom row
                else if (lblBL.Text == lblBM.Text && lblBM.Text == lblBR.Text && lblBL.Text != " ")
                {
                    MessageBox.Show("There is a winner!");
                    Clear();
                }

                // \ winner
                else if (lblTL.Text == lblMM.Text && lblMM.Text == lblBR.Text && lblTL.Text != " ")
                {
                    MessageBox.Show("There is a winner!");
                    Clear();
                }

                // / winner
                else if (lblTR.Text == lblMM.Text && lblMM.Text == lblBL.Text && lblTR.Text != " ")
                {
                    MessageBox.Show("There is a winner!");
                    Clear();
                }

                // Left horizontal

                else if (lblBL.Text == lblML.Text && lblML.Text == lblTL.Text && lblBL.Text != " ")
                {
                    MessageBox.Show("There is a winner!");
                    Clear();
                }

                // Middle horizontal
                else if (lblTM.Text == lblMM.Text && lblMM.Text == lblBM.Text && lblTM.Text != " ")
                {
                    MessageBox.Show("There is a winner!");
                    Clear();
                }

                // Right horizontal
                else if (lblTR.Text == lblMR.Text && lblMR.Text == lblBR.Text && lblTR.Text != " ")
                {
                    MessageBox.Show("There is a winner!");
                    Clear();
                }

                if (counter == 9)
                {
                    MessageBox.Show("It's a tie!");
                    Clear();
                }


        }

        private void Clear()
        {
            CurrentPlayer = 'X';
            button1.Visible = true;
            button2.Visible = true;
            button3.Visible = true;
            button4.Visible = true;
            button5.Visible = true;
            button6.Visible = true;
            button7.Visible = true;
            button8.Visible = true;
            button9.Visible = true;

            lblTL.Visible = false;
            lblTM.Visible = false;
            lblTR.Visible = false;
            lblML.Visible = false;
            lblMM.Visible = false;
            lblMR.Visible = false;
            lblBL.Visible = false;
            lblBM.Visible = false;
            lblBR.Visible = false;


            lblTL.Text = " ";
            lblTM.Text = " ";
            lblTR.Text = " ";
            lblML.Text = " ";
            lblMM.Text = " ";
            lblMR.Text = " ";
            lblBL.Text = " ";
            lblBM.Text = " ";
            lblBR.Text = " ";

            counter = 0;
        }

        private void button1_Click(object sender, EventArgs e)
        {

            lblTL.Visible = true;
            button1.Visible = false;

            if (CurrentPlayer == Player1)
            {
                lblTL.Text = Player1.ToString();
                CurrentPlayer = Player2;
            }
            else if (CurrentPlayer == Player2)
            {
                lblTL.Text = Player2.ToString();
                CurrentPlayer = Player1;
            }
            counter++;
            Winner();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            lblTM.Visible = true;
            button2.Visible = false;

            if (CurrentPlayer == Player1)
            {
                lblTM.Text = Player1.ToString();
                CurrentPlayer = Player2;
            }
            else if (CurrentPlayer == Player2)
            {
                lblTM.Text = Player2.ToString();
                CurrentPlayer = Player1;
            }
            counter++;
            Winner();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            lblTR.Visible = true;
            button3.Visible = false;

            if (CurrentPlayer == Player1)
            {
                lblTR.Text = Player1.ToString();
                CurrentPlayer = Player2;
            }
            else if (CurrentPlayer == Player2)
            {
                lblTR.Text = Player2.ToString();
                CurrentPlayer = Player1;
            }
            counter++;
            Winner();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            lblML.Visible = true;
            button5.Visible = false;

            if (CurrentPlayer == Player1)
            {
                lblML.Text = Player1.ToString();
                CurrentPlayer = Player2;
            }
            else if (CurrentPlayer == Player2)
            {
                lblML.Text = Player2.ToString();
                CurrentPlayer = Player1;
            }
            counter++;
            Winner();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            lblMM.Visible = true;
            button4.Visible = false;

            if (CurrentPlayer == Player1)
            {
                lblMM.Text = Player1.ToString();
                CurrentPlayer = Player2;
            }
            else if (CurrentPlayer == Player2)
            {
                lblMM.Text = Player2.ToString();
                CurrentPlayer = Player1;
            }
            counter++;
            Winner();
        }

        private void button6_Click(object sender, EventArgs e)
        {
            lblMR.Visible = true;
            button6.Visible = false;

            if (CurrentPlayer == Player1)
            {
                lblMR.Text = Player1.ToString();
                CurrentPlayer = Player2;
            }
            else if (CurrentPlayer == Player2)
            {
                lblMR.Text = Player2.ToString();
                CurrentPlayer = Player1;
            }
            counter++;
            Winner();
        }

        private void button7_Click(object sender, EventArgs e)
        {
            lblBL.Visible = true;
            button7.Visible = false;

            if (CurrentPlayer == Player1)
            {
                lblBL.Text = Player1.ToString();
                CurrentPlayer = Player2;
            }
            else if (CurrentPlayer == Player2)
            {
                lblBL.Text = Player2.ToString();
                CurrentPlayer = Player1;
            }
            counter++;
            Winner();
        }

        private void button8_Click(object sender, EventArgs e)
        {
            lblBM.Visible = true;
            button8.Visible = false;

            if (CurrentPlayer == Player1)
            {
                lblBM.Text = Player1.ToString();
                CurrentPlayer = Player2;
            }
            else if (CurrentPlayer == Player2)
            {
                lblBM.Text = Player2.ToString();
                CurrentPlayer = Player1;
            }
            counter++;
            Winner();
        }

        private void button9_Click(object sender, EventArgs e)
        {
            lblBR.Visible = true;
            button9.Visible = false;

            if (CurrentPlayer == Player1)
            {
                lblBR.Text = Player1.ToString();
                CurrentPlayer = Player2;
            }
            else if (CurrentPlayer == Player2)
            {
                lblBR.Text = Player2.ToString();
                CurrentPlayer = Player1;
            }
            counter++;
            Winner();
        }

        private void btnReset_Click(object sender, EventArgs e)
        {
            Clear();
        }

      
        
    }
}
