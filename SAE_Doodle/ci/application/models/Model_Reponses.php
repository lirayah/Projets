<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Model_Reponses extends CI_Model{

    public function __construct()
    {
        $this->load->database();
    }

    public function getInfos($cle){
        $sql = "SELECT * FROM Sondage NATURAL JOIN DatesProposees WHERE cleSondage=?";
        $query = $this->db->query($sql, [$cle]);
        return $query->result_array();
    }

    public function isOpen($cle) {
        $sql = "SELECT open FROM Sondage WHERE cleSondage=?";
        $query = $this->db->query($sql, [$cle]);
        if($query->num_rows()!==0){
            return $query->row()->open;
        } else {
            return FALSE;
        }
    }

    public function setParticipants($cle,$nom,$prenom) {
        $sql="INSERT INTO `Participants`(`cleSondage`, `Nom`, `Prenom`) VALUES (?,?,?)";
        $this->db->query($sql,[$cle,$nom,$prenom]);
        $sql="SELECT id FROM Participants WHERE cleSondage=? AND Nom=? AND Prenom=?";
        $query = $this->db->query($sql,[$cle,$nom,$prenom]);
        return $query->row()->id;
    }

    public function setDates($id,$dates,$cle)
    {
        foreach ($dates as $dadates) {
            $sql="INSERT INTO DatesReponses VALUES(?,?)";

            $sql2="UPDATE DatesProposees 
            SET votes=(SELECT votes FROM DatesProposees WHERE cleSondage=? AND dates=?)+1
            WHERE cleSondage=? AND dates=?";

            $this->db->query($sql2,[$cle,$dadates,$cle,$dadates]);
            $this->db->query($sql,[$id,$dadates]);
        }
    }
}