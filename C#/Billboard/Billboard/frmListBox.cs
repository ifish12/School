using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;
using Microsoft.VisualBasic;

namespace Billboard
{
    public partial class frmListBox : Form
    {
        string Prompt = "Please tell me the name of the .txt file";
        string Title = "Top 10 charts";
        string name = "";

        string[,] SongTree = new string[10, 5]; // 0 = Track, 1 = Artist, 2 = Current rating, 3 = previous rating, 4 = usual rating
        public frmListBox()
        {
            InitializeComponent();
        }

        private void btnGo_Click(object sender, EventArgs e)
        {
            try
            {
                name = Convert.ToString(Microsoft.VisualBasic.Interaction.InputBox(Prompt , Title));


                StreamReader inFile;
                inFile = File.OpenText(name + ".txt");
                for (int index = 0; index < 10; index++)
                {
                    String s = inFile.ReadLine();
                    string[] output = s.Split('/');

                    listBox1.Items.Add(output[0]);
                    
                    SongTree[index, 0] = output[0];
                    SongTree[index, 1] = output[1];
                    SongTree[index, 2] = output[2];
                    SongTree[index, 3] = output[3];
                    SongTree[index, 4] = output[4];
                  
                }
                inFile.Close();
            }
            catch
            {
                MessageBox.Show("No such file name exists");
            }


        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            
            lblArtist.Text = SongTree[listBox1.SelectedIndex, 1].ToString();
            lblCurList.Text = SongTree[listBox1.SelectedIndex, 2].ToString();
            lblPrevList.Text = SongTree[listBox1.SelectedIndex, 3].ToString();
            lblAvgList.Text = SongTree[listBox1.SelectedIndex, 4].ToString();
            
        

        }
    }
}
