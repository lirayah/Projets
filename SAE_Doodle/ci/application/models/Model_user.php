<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Model_user extends CI_Model{

    public function __construct()
    {
        $this->load->database();
    }

    public function creerCompte($name,$prenom,$email,$login,$hash){
        $sql = "INSERT INTO Compte values(?,?,?,?,?)";
        $this->db->query($sql,[$name,$prenom,$email,$login,$hash]);
    }

    public function authentification($login){
        $sql = "SELECT password from Compte where login=?";
        $query = $this->db->query($sql,[$login]);
        if($query->num_rows()!==0){
            $hash = $query->row()->password;
        }
        else{
            return FALSE;
        }
        return $hash;
    }

    public function info($login){
        $sql = "SELECT * FROM Compte where email=?";
        $query = $this->db->query($sql,[$login]);
        $tab=array(
            'prenom' => $query->row()->prenom,
            'nom' => $query->row()->nom,
            'email' => $query->row()->email,
            'login' => $login,
            'logged_in' => TRUE
        );
        return $tab;
    }

    public function verification($login)
    {
        $sql ="SELECT login from Compte where login=?";
        $query = $this->db->query($sql,[$login]);
        if ($query->num_rows()!==0) {
            return FALSE;
        } else {
            return TRUE;
        }
    }

    public function getInfos($login)
    {
        $sql="SELECT * FROM Compte WHERE login=?";
        $query=$this->db->query($sql,[$login]);
        return $query->result_array();
    }

    public function modifierCompte($name,$prenom,$email,$passhash,$newlogin,$oldlogin)
    {
        $sql="UPDATE Compte 
        set nom=?, prenom=?, email=?, password=?, login=?
        WHERE login=?";
        $this->db->query($sql,[$name,$prenom,$email,$passhash,$newlogin,$oldlogin]);
    }
}