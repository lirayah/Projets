<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Model_consulter extends CI_Model{

    public function __construct()
    {
        $this->load->database();
    }

    public function aff_profil($login){
        $sql = "SELECT *
        FROM Sondage
        WHERE createur=?";
        $query=$this->db->query($sql,[$login]);
        return $query->result_array();
    }

    

    public function recup_sond($cle){
        $sql = "SELECT * 
        FROM Sondage
        WHERE cleSondage=?";
        $query=$this->db->query($sql,[$cle]);
        return $query->result_array();
    }

    public function recup_prop($cle){
        $sql = "SELECT * 
        FROM DatesProposees
        WHERE cleSondage=?
        ORDER BY votes DESC";
        $query=$this->db->query($sql,[$cle]);
        return $query->result_array();
    }
    
    public function recup_par($cle){
        $sql = "SELECT * 
        FROM Participants NATURAL JOIN DatesReponses
        WHERE cleSondage=?
        ORDER BY id, dates";
        $query=$this->db->query($sql,[$cle]);
        return $query->result_array();
    }

    public function céletien($cle){
        $sql = "SELECT createur
        FROM Sondage
        WHERE cleSondage=?";
        $query=$this->db->query($sql,[$cle]);
        return $query->result_array();
    }
}