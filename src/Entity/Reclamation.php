<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * Reclamation
 *
 * @ORM\Table(name="reclamation", indexes={@ORM\Index(name="fk_user", columns={"id_user"})})
 * @ORM\Entity
 */
class Reclamation
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer", nullable=false )
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
   
     *
     * @ORM\Column(name="email", type="string", length=255, nullable=false)
     
     * @Assert\Email(strict=true, message="Le format de l'email est incorrect")
 * @Assert\Email(checkMX=true, message="Aucun serveur mail n'a été trouvé pour ce domaine")
     */

    private $email;

    /**
     * @var string
     *
     * @ORM\Column(name="sujet", type="string", length=222, nullable=false)
     */
    private $sujet;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=222, nullable=false)
     */
    private $description;

    /**
     * @var string|null
     *
     * @ORM\Column(name="etat", type="string", length=200, nullable=true)
     */
    private $etat;

     /**
     * @var \Utilisateur
     *
     * @ORM\ManyToOne(targetEntity="Utilisateur")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_coach", referencedColumnName="id_utilisateur")
     * })
     */
    private $idCoach;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date", type="date", nullable=false, options={"default"="CURRENT_TIMESTAMP"})
     */
    private $date = 'CURRENT_TIMESTAMP';

    /**
     * @var \Utilisateur
     *
     * @ORM\ManyToOne(targetEntity="Utilisateur")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_user", referencedColumnName="id_utilisateur")
     * })
     */
    private $idUser;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getEmail(): ?string
    {
        return $this->email;
    }

    public function setEmail(string $email): self
    {
        $this->email = $email;

        return $this;
    }

    public function getSujet(): ?string
    {
        return $this->sujet;
    }

    public function setSujet(string $sujet): self
    {
        $this->sujet = $sujet;

        return $this;
    }

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(string $description): self
    {
        $this->description = $description;

        return $this;
    }

    public function getEtat(): ?string
    {
        return $this->etat;
    }

    public function setEtat(?string $etat): self
    {
        $this->etat = $etat;

        return $this;
    }

    public function getIdCoach(): ?Utilisateur
    {
        return $this->idCoach;
    }

    public function setIdCoach(?Utilisateur $idCoach): self
    {
        $this->idCoach = $idCoach;

        return $this;
    }

    public function getDate(): ?\DateTimeInterface
    {
        return $this->date;
    }

    public function setDate(\DateTimeInterface $date): self
    {
        $this->date = $date;
        
        return $this;
    }


    public function getIdUser(): ?Utilisateur
    {
        return $this->idUser;
    }

    public function setIdUser(?Utilisateur $idUser): self
    {
        $this->idUser = $idUser;

        return $this;
    }
    public function __construct()
    {
        $this->date = new \DateTime('now');

    }
  
    public function __toString(){
        return (string) $this->getId();
        
        
    }
}
