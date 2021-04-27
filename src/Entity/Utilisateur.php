<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Validator\Validator\ValidatorInterface;
use Symfony\Bridge\Doctrine\Validator\Constraints\UniqueEntity;


/**
 * Utilisateur
 *
 * @ORM\Table(name="utilisateur", indexes={@ORM\Index(name="heyy", columns={"id_role"})})
 * @ORM\Entity
 * @UniqueEntity(
 * fields={"username"},
 * message="le nom d'utilisateur que vous avez indiqué est deja utilisé" 
 * )
 */
class Utilisateur implements UserInterface
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_utilisateur", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idUtilisateur;

    /**
     * @var string
     *
     * @ORM\Column(name="username", type="string", length=100, nullable=false)
     * @Assert\NotBlank(message="Username est obligatoire")
     */
    private $username;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=100, nullable=false)
     * @Assert\NotBlank(message="Nom est obligatoire")
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="prenom", type="string", length=100, nullable=false)
     * @Assert\NotBlank(message="Prenom est obligatoire")
     */
    private $prenom;

    /**
     * @var string
     *
     * @ORM\Column(name="password", type="string", length=100, nullable=false)
     * @Assert\NotBlank(message="Mot de passe est obligatoire")
     * * @Assert\Length(
     *      min = 8,
     *      minMessage = "votre mot de passe doit faire minimum 8 caractere.",
     *      allowEmptyString = false
     * )
     * @Assert\EqualTo(propertyPath="confirm_password", message="vous n'avez pas tapez le meme mot de passe")
     */
    private $password;
    
    
    /**
     * @var string
     *
     * @ORM\Column(name="tel", type="string", length=20, nullable=false)
     * @Assert\NotBlank(message="Numero de tel. est obligatoire")
     * @Assert\Length(
     *      min = 8,
     *      minMessage = "votre numéro de tel. doit avoir {{ limit }} chiffres.",
     *      allowEmptyString = false
     * )
     */
    private $tel;

    /**
     * @var string
     *
     * @ORM\Column(name="adresse", type="string", length=100, nullable=false)
     * @Assert\NotBlank(message="Adresse est obligatoire")
     */
    private $adresse;

    /**
     * @var int
     *
     * @ORM\Column(name="id_role", type="integer", nullable=false)
     * @Assert\NotBlank(message="Role est obligatoire")
     */
    private $idRole;

    /**
     * @var int
     *
     * @ORM\Column(name="etat", type="integer", nullable=false)
     * @Assert\NotBlank(message="Etat est obligatoire")
     */
    private $etat;

    /**
     * @var string
     *
     * @ORM\Column(name="email", type="string", length=100, nullable=false)
     * @Assert\NotBlank(message="L'adresse mail est obligatoire")
     * @Assert\Email(message = "Cette adresse mail n'est pas valide.")
     */
    private $email;

    /**
     * @Assert\EqualTo(propertyPath="password" , message="vous n'avez pas tapez le meme mot de passe")
     */

    public $confirm_password;


    /**
    * @ORM\Column(type="json")
    */
    private $roles = [];


    public function setRoles(array $roles): self
    {
        $this->roles = $roles;
        return $this;
    }

    public function getIdUtilisateur(): ?int
    {
        return $this->idUtilisateur;
    }

    public function getUsername(): ?string
    {
        return $this->username;
    }

    public function setUsername(string $username): self
    {
        $this->username = $username;

        return $this;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(string $nom): self
    {
        $this->nom = $nom;

        return $this;
    }

    public function getPrenom(): ?string
    {
        return $this->prenom;
    }

    public function setPrenom(string $prenom): self
    {
        $this->prenom = $prenom;

        return $this;
    }

    public function getPassword(): ?string
    {
        return $this->password;
    }

    public function setPassword(string $password): self
    {
        $this->password = $password;

        return $this;
    }

    public function getTel(): ?string
    {
        return $this->tel;
    }

    public function setTel(string $tel): self
    {
        $this->tel = $tel;

        return $this;
    }

    public function getAdresse(): ?string
    {
        return $this->adresse;
    }

    public function setAdresse(string $adresse): self
    {
        $this->adresse = $adresse;

        return $this;
    }

    public function getIdRole(): ?int
    {
        return $this->idRole;
    }

    public function setIdRole(int $idRole): self
    {
        $this->idRole = $idRole;

        return $this;
    }

    public function getEtat(): ?int
    {
        return $this->etat;
    }

    public function setEtat(int $etat): self
    {
        $this->etat = $etat;

        return $this;
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

    public function eraseCredentials() {}
    public function getSalt() {}
    public function getRoles(): array
    {
        $roles = $this->roles;
        // guarantee every user at least has ROLE_USER
        $roles[] = 'ROLE_USER';
        return array_unique($this->roles);
    }

}
