<?php
if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class ModelSondage extends CI_Model{

    public function __construct()
    {
        parent::__construct();
        $this->load->database();
        $this->load->library('session');
    }

    public function random_kiki(){
        $length=64;
        $chars = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
        $string = '';
        for($i=0; $i<$length; $i++){
            $string .= $chars[rand(0, strlen($chars)-1)];
        }
        return $string;
    }

    public function creation($titre,$lieu,$descriptif,$createur,$dates,$cle){
        $sql="INSERT INTO Sondage values(?,?,?,?,?,TRUE)";
        $this->db->query($sql,[$titre,$lieu,$descriptif,$createur,$cle]);
        foreach($dates as $dadat){
            $sql2="INSERT INTO DatesProposees values(?,?,0)";
            $this->db->query($sql2,[$dadat,$cle]);
        }
    }


    public function fermeture($cle)
    {
        $sql="UPDATE Sondage SET open=0 WHERE cleSondage=?";
        $this->db->query($sql,[$cle]);
    }

    public function ouverture($cle)
    {
        $sql="UPDATE Sondage SET open=1 WHERE cleSondage=?";
        $this->db->query($sql,[$cle]);
    }

    public function suppression($cle)
    {
        $sql="DELETE FROM Sondage 
        WHERE cleSondage=?";
        $this->db->query($sql,[$cle]);
    }

    
    public function getInfos($cle)
    {
        $sql="SELECT * FROM Sondage WHERE cleSondage=?";
        $query=$this->db->query($sql,[$cle]);
        return $query->result_array();
    }

    public function modifier($titre,$lieu,$descriptif,$cle)
    {
        $sql="UPDATE Sondage set titre=?, lieu=?, descriptif=? WHERE cleSondage=?";
        $this->db->query($sql,[$titre,$lieu,$descriptif,$cle]);
    }

}
?>