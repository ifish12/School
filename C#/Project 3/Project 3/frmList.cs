using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Project_3
{
    public partial class frmList : Form
    {
        string city = "";

        public frmList()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

   
        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void lstCity_SelectedIndexChanged(object sender, EventArgs e)
        {

            if (lstCity.SelectedIndex != -1)
            {
                city = lstCity.SelectedItem.ToString();

                switch (city)
                {
                    case "Honolulu": lblOutTime.Text = "Hawaii Aleutian";
                        break;
                    case "San Francisco": lblOutTime.Text = "Pacific Standard Time";
                        break;
                    case "Denver": lblOutTime.Text = "Mountain Time";
                        break;
                    case "New York": lblOutTime.Text = "Eastern Standard Time";
                        break;
                    case "Minneapolis": lblOutTime.Text = "Central Standard Time";
                        break;

                }
            }
            else
            {
                MessageBox.Show("Please select a city");
            }
        }
    }
}
