<?php

use Twig\Environment;
use Twig\Error\LoaderError;
use Twig\Error\RuntimeError;
use Twig\Extension\SandboxExtension;
use Twig\Markup;
use Twig\Sandbox\SecurityError;
use Twig\Sandbox\SecurityNotAllowedTagError;
use Twig\Sandbox\SecurityNotAllowedFilterError;
use Twig\Sandbox\SecurityNotAllowedFunctionError;
use Twig\Source;
use Twig\Template;

/* panier/_form.html.twig */
class __TwigTemplate_79236e0f312ec13ed1b73f333f572c1fabf8f6091526c50818cd2b0f067b0ff5 extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->parent = false;

        $this->blocks = [
        ];
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "panier/_form.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "panier/_form.html.twig"));

        // line 1
        echo "

    <div class=\"content-wrapper\">
        <div class=\"content-header row\">
        </div>
        <div class=\"content-body\">
            <!-- users edit start -->
            <section class=\"users-edit\">
                <div class=\"card\">
                    <div class=\"card-content\">
                        <div class=\"card-body\">
                          
                            <div class=\"tab-content\">
                                <div class=\"tab-pane active\" id=\"account\" aria-labelledby=\"account-tab\" role=\"tabpanel\">
                                    <!-- users edit media object start -->

                                    <!-- users edit media object ends -->
                                    <!-- users edit account form start -->
                                    ";
        // line 19
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock((isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 19, $this->source); })()), 'form_start');
        echo "

                                    <div class=\"row\">
                                        <div class=\"col-12 col-sm-6\">
                                            <div class=\"form-group\">
                                                <div class=\"controls\">


                                                </div>
                                            </div>
                                            <div class=\"form-group\">
                                                <div class=\"controls\">
                                                    <label>Nom</label>
                                                    ";
        // line 32
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 32, $this->source); })()), "nom", [], "any", false, false, false, 32), 'widget', ["label" => "", "id" => "user-company", "attr" => ["class" => "form-control col-12 col-sm-7 ", "placeholder" => "nom *"]]);
        echo "
                                                    <div class=\"alert alert-danger\">
                                                        ";
        // line 34
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 34, $this->source); })()), "nom", [], "any", false, false, false, 34), 'errors');
        echo "
                                                    </div>
                                                </div>
                                            </div>
                                            <div class=\"form-group\">
                                                <div class=\"controls\">
                                                    <label>Prix</label>
                                                    ";
        // line 41
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 41, $this->source); })()), "prix", [], "any", false, false, false, 41), 'widget', ["label" => "", "id" => "user-company", "attr" => ["class" => "form-control col-12 col-sm-7 ", "placeholder" => "prix *"]]);
        echo "
                                                    <div class=\"alert alert-danger\">
                                                        ";
        // line 43
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 43, $this->source); })()), "prix", [], "any", false, false, false, 43), 'errors');
        echo "
                                                    </div>
                                                </div>
                                            </div>
                                            <div class=\"form-group\">
                                            <div class=\"controls\">
                                                <label>Quantité</label>
                                                ";
        // line 50
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 50, $this->source); })()), "qte", [], "any", false, false, false, 50), 'widget', ["label" => "", "id" => "user-company", "attr" => ["class" => "form-control col-12 col-sm-7 ", "placeholder" => "quantité *"]]);
        echo "
                                                <div class=\"alert alert-danger\">
                                                    ";
        // line 52
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 52, $this->source); })()), "qte", [], "any", false, false, false, 52), 'errors');
        echo "
                                                </div>
                                            </div>
                                        </div>
                                            <div class=\"form-group\">
                                                <div class=\"controls\">
                                                    <label>Total</label>
                                                    ";
        // line 59
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 59, $this->source); })()), "total", [], "any", false, false, false, 59), 'widget', ["label" => "", "id" => "user-password", "attr" => ["class" => "form-control col-12 col-sm-7 ", "placeholder" => "total *"]]);
        echo "
                                                    <div class=\"alert alert-danger\">
                                                        ";
        // line 61
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 61, $this->source); })()), "total", [], "any", false, false, false, 61), 'errors');
        echo "
                                                    </div>
                                                </div>
                                            </div>
                                         
                                       


                                            <div class=\"col-md-offset-5\" > <button type=\"submit\" href=\"";
        // line 69
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("panier_new");
        echo "\" class=\"btn btn-primary mt30 btn-black \"/>click to save </button> </div>
                                            ";
        // line 70
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock((isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 70, $this->source); })()), 'form_end');
        echo "



                                        </div>
                                    </div>


                                </div>


                                <div class=\"tab-pane\" id=\"information\" aria-labelledby=\"information-tab\" role=\"tabpanel\">
                                    <!-- users edit Info form start -->
                                    <form novalidate>
                                        <div class=\"row mt-1\">
                                            <div class=\"col-12 col-sm-6\">
                                                <h5 class=\"mb-1\"><i class=\"feather icon-user mr-25\"></i>Personal Information</h5>
                                                <div class=\"row\">
                                                    <div class=\"col-12\">
                                                        <div class=\"form-group\">
                                                            <div class=\"controls\">
                                                                <label>Birth date</label>
                                                                <input type=\"text\" class=\"form-control birthdate-picker\" required placeholder=\"Birth date\" data-validation-required-message=\"This birthdate field is required\">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class=\"form-group\">
                                                    <div class=\"controls\">
                                                        <label>Mobile</label>
                                                        <input type=\"text\" class=\"form-control\" value=\"&#43;6595895857\" placeholder=\"Mobile number here...\" data-validation-required-message=\"This mobile number is required\">
                                                    </div>
                                                </div>

                                                <div class=\"form-group\">
                                                    <div class=\"controls\">
                                                        <label>Website</label>
                                                        <input type=\"text\" class=\"form-control\" required placeholder=\"Website here...\" value=\"https://rowboat.com/insititious/Angelo\" data-validation-required-message=\"This Website field is required\">
                                                    </div>
                                                </div>
                                                <div class=\"form-group\">
                                                    <label>Languages</label>
                                                    <select class=\"form-control\" id=\"users-language-select2\" multiple=\"multiple\">
                                                        <option value=\"English\" selected>English</option>
                                                        <option value=\"Spanish\">Spanish</option>
                                                        <option value=\"French\">French</option>
                                                        <option value=\"Russian\">Russian</option>
                                                        <option value=\"German\">German</option>
                                                        <option value=\"Arabic\" selected>Arabic</option>
                                                        <option value=\"Sanskrit\">Sanskrit</option>
                                                    </select>
                                                </div>
                                                <div class=\"form-group\">
                                                    <label>Gender</label>
                                                    <ul class=\"list-unstyled mb-0\">
                                                        <li class=\"d-inline-block mr-2\">
                                                            <fieldset>
                                                                <div class=\"vs-radio-con\">
                                                                    <input type=\"radio\" name=\"vueradio\" checked value=\"false\">
                                                                    <span class=\"vs-radio\">
                                                                            <span class=\"vs-radio--border\"></span>
                                                                            <span class=\"vs-radio--circle\"></span>
                                                                        </span>
                                                                    Male
                                                                </div>
                                                            </fieldset>
                                                        </li>
                                                        <li class=\"d-inline-block mr-2\">
                                                            <fieldset>
                                                                <div class=\"vs-radio-con\">
                                                                    <input type=\"radio\" name=\"vueradio\" value=\"false\">
                                                                    <span class=\"vs-radio\">
                                                                            <span class=\"vs-radio--border\"></span>
                                                                            <span class=\"vs-radio--circle\"></span>
                                                                        </span>
                                                                    Female
                                                                </div>
                                                            </fieldset>
                                                        </li>
                                                        <li class=\"d-inline-block mr-2\">
                                                            <fieldset>
                                                                <div class=\"vs-radio-con\">
                                                                    <input type=\"radio\" name=\"vueradio\" value=\"false\">
                                                                    <span class=\"vs-radio\">
                                                                            <span class=\"vs-radio--border\"></span>
                                                                            <span class=\"vs-radio--circle\"></span>
                                                                        </span>
                                                                    Other
                                                                </div>
                                                            </fieldset>
                                                        </li>

                                                    </ul>
                                                </div>
                                                <div class=\"form-group\">
                                                    <label>Contact Options</label>
                                                    <ul class=\"list-unstyled mb-0\">
                                                        <li class=\"d-inline-block mr-2\">
                                                            <fieldset>
                                                                <div class=\"custom-control custom-checkbox\">
                                                                    <input type=\"checkbox\" class=\"custom-control-input\" checked name=\"customCheck1\" id=\"customCheck1\">
                                                                    <label class=\"custom-control-label\" for=\"customCheck1\">Email</label>
                                                                </div>
                                                            </fieldset>
                                                        </li>
                                                        <li class=\"d-inline-block mr-2\">
                                                            <fieldset>
                                                                <div class=\"custom-control custom-checkbox\">
                                                                    <input type=\"checkbox\" class=\"custom-control-input\" checked name=\"customCheck2\" id=\"customCheck2\">
                                                                    <label class=\"custom-control-label\" for=\"customCheck2\">Message</label>
                                                                </div>
                                                            </fieldset>
                                                        </li>
                                                        <li class=\"d-inline-block mr-2\">
                                                            <fieldset>
                                                                <div class=\"custom-control custom-checkbox\">
                                                                    <input type=\"checkbox\" class=\"custom-control-input\" name=\"customCheck3\" id=\"customCheck3\">
                                                                    <label class=\"custom-control-label\" for=\"customCheck3\">Phone</label>
                                                                </div>
                                                            </fieldset>
                                                        </li>
                                                    </ul>
                                                </div>

                                            </div>
                                            <div class=\"col-12 col-sm-6\">
                                                <h5 class=\"mb-1 mt-2 mt-sm-0\"><i class=\"feather icon-map-pin mr-25\"></i>Address</h5>
                                                <div class=\"form-group\">
                                                    <div class=\"controls\">
                                                        <label>Address Line 1</label>
                                                        <input type=\"text\" class=\"form-control\" value=\"A-65, Belvedere Streets\" required placeholder=\"Address Line 1\" data-validation-required-message=\"This Address field is required\">
                                                    </div>
                                                </div>
                                                <div class=\"form-group\">
                                                    <div class=\"controls\">
                                                        <label>Address Line 2</label>
                                                        <input type=\"text\" class=\"form-control\" required placeholder=\"Address Line 2\" data-validation-required-message=\"This Address field is required\">
                                                    </div>
                                                </div>
                                                <div class=\"form-group\">
                                                    <div class=\"controls\">
                                                        <label>Postcode</label>
                                                        <input type=\"text\" class=\"form-control\" required placeholder=\"postcode\" value=\"1868\" data-validation-required-message=\"This Postcode field is required\">
                                                    </div>
                                                </div>
                                                <div class=\"form-group\">
                                                    <div class=\"controls\">
                                                        <label>City</label>
                                                        <input type=\"text\" class=\"form-control\" required value=\"New York\" data-validation-required-message=\"This Time Zone field is required\">
                                                    </div>
                                                </div>
                                                <div class=\"form-group\">
                                                    <div class=\"controls\">
                                                        <label>State</label>
                                                        <input type=\"text\" class=\"form-control\" required value=\"New York\" data-validation-required-message=\"This Time Zone field is required\">
                                                    </div>
                                                </div>
                                                <div class=\"form-group\">
                                                    <div class=\"controls\">
                                                        <label>Country</label>
                                                        <input type=\"text\" class=\"form-control\" required value=\"United Kingdom\" data-validation-required-message=\"This Time Zone field is required\">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class=\"col-12 d-flex flex-sm-row flex-column justify-content-end mt-1\">
                                                <button type=\"submit\" class=\"btn btn-primary glow mb-1 mb-sm-0 mr-0 mr-sm-1\">Save
                                                    Changes</button>
                                                <button type=\"reset\" class=\"btn btn-outline-warning\">Reset</button>
                                            </div>
                                        </div>
                                    </form>
                                    <!-- users edit Info form ends -->
                                </div>
                                <div class=\"tab-pane\" id=\"social\" aria-labelledby=\"social-tab\" role=\"tabpanel\">
                                    <!-- users edit socail form start -->
                                    <form novalidate>
                                        <div class=\"row\">
                                            <div class=\"col-12 col-sm-6\">

                                                <fieldset>
                                                    <label>Twitter</label>
                                                    <div class=\"input-group mb-75\">
                                                        <div class=\"input-group-prepend\">
                                                            <span class=\"input-group-text feather icon-twitter\" id=\"basic-addon3\"></span>
                                                        </div>
                                                        <input type=\"text\" class=\"form-control\" value=\"https://www.twitter.com/adoptionism744\" placeholder=\"https://www.twitter.com/\" aria-describedby=\"basic-addon3\">
                                                    </div>

                                                    <label>Facebook</label>
                                                    <div class=\"input-group mb-75\">
                                                        <div class=\"input-group-prepend\">
                                                            <span class=\"input-group-text feather icon-facebook\" id=\"basic-addon4\"></span>
                                                        </div>
                                                        <input type=\"text\" class=\"form-control\" value=\"https://www.facebook.com/adoptionism664\" placeholder=\"https://www.facebook.com/\" aria-describedby=\"basic-addon4\">
                                                    </div>
                                                    <label>Instagram</label>
                                                    <div class=\"input-group mb-75\">
                                                        <div class=\"input-group-prepend\">
                                                            <span class=\"input-group-text feather icon-instagram\" id=\"basic-addon5\"></span>
                                                        </div>
                                                        <input type=\"text\" class=\"form-control\" value=\"https://www.instagram.com/adopt-ionism744\" placeholder=\"https://www.instagram.com/\" aria-describedby=\"basic-addon5\">
                                                    </div>
                                                </fieldset>
                                            </div>
                                            <div class=\"col-12 col-sm-6\">
                                                <label>Github</label>
                                                <div class=\"input-group mb-75\">
                                                    <div class=\"input-group-prepend\">
                                                        <span class=\"input-group-text feather icon-github\" id=\"basic-addon9\"></span>
                                                    </div>
                                                    <input type=\"text\" class=\"form-control\" value=\"https://www.github.com/madop818\" placeholder=\"https://www.github.com/\" aria-describedby=\"basic-addon9\">
                                                </div>
                                                <label>Codepen</label>
                                                <div class=\"input-group mb-75\">
                                                    <div class=\"input-group-prepend\">
                                                        <span class=\"input-group-text feather icon-codepen\" id=\"basic-addon12\"></span>
                                                    </div>
                                                    <input type=\"text\" class=\"form-control\" value=\"https://www.codepen.com/adoptism243\" placeholder=\"https://www.codepen.com/\" aria-describedby=\"basic-addon12\">
                                                </div>
                                                <label>Slack</label>
                                                <div class=\"input-group mb-75\">
                                                    <div class=\"input-group-prepend\">
                                                        <span class=\"input-group-text feather icon-slack\" id=\"basic-addon11\"></span>
                                                    </div>
                                                    <input type=\"text\" class=\"form-control\" value=\"@adoptionism744\" placeholder=\"https://www.slack.com/\" aria-describedby=\"basic-addon11\">
                                                </div>
                                            </div>
                                            <div class=\"col-12 d-flex flex-sm-row flex-column justify-content-end mt-1\">
                                                <button type=\"submit\" class=\"btn btn-primary glow mb-1 mb-sm-0 mr-0 mr-sm-1\">Save
                                                    Changes</button>
                                                <button type=\"reset\" class=\"btn btn-outline-warning\">Reset</button>
                                            </div>
                                        </div>
                                    </form>
                                    <!-- users edit socail form ends -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        















";
        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    public function getTemplateName()
    {
        return "panier/_form.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  144 => 70,  140 => 69,  129 => 61,  124 => 59,  114 => 52,  109 => 50,  99 => 43,  94 => 41,  84 => 34,  79 => 32,  63 => 19,  43 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("

    <div class=\"content-wrapper\">
        <div class=\"content-header row\">
        </div>
        <div class=\"content-body\">
            <!-- users edit start -->
            <section class=\"users-edit\">
                <div class=\"card\">
                    <div class=\"card-content\">
                        <div class=\"card-body\">
                          
                            <div class=\"tab-content\">
                                <div class=\"tab-pane active\" id=\"account\" aria-labelledby=\"account-tab\" role=\"tabpanel\">
                                    <!-- users edit media object start -->

                                    <!-- users edit media object ends -->
                                    <!-- users edit account form start -->
                                    {{ form_start(form) }}

                                    <div class=\"row\">
                                        <div class=\"col-12 col-sm-6\">
                                            <div class=\"form-group\">
                                                <div class=\"controls\">


                                                </div>
                                            </div>
                                            <div class=\"form-group\">
                                                <div class=\"controls\">
                                                    <label>Nom</label>
                                                    {{ form_widget(form.nom,{ 'label':'','id' : 'user-company','attr':{'class':'form-control col-12 col-sm-7 ','placeholder':'nom *'}}) }}
                                                    <div class=\"alert alert-danger\">
                                                        {{ form_errors(form.nom) }}
                                                    </div>
                                                </div>
                                            </div>
                                            <div class=\"form-group\">
                                                <div class=\"controls\">
                                                    <label>Prix</label>
                                                    {{ form_widget(form.prix,{ 'label':'','id' : 'user-company','attr':{'class':'form-control col-12 col-sm-7 ','placeholder':'prix *'}}) }}
                                                    <div class=\"alert alert-danger\">
                                                        {{ form_errors(form.prix) }}
                                                    </div>
                                                </div>
                                            </div>
                                            <div class=\"form-group\">
                                            <div class=\"controls\">
                                                <label>Quantité</label>
                                                {{ form_widget(form.qte,{ 'label':'','id' : 'user-company','attr':{'class':'form-control col-12 col-sm-7 ','placeholder':'quantité *'}}) }}
                                                <div class=\"alert alert-danger\">
                                                    {{ form_errors(form.qte) }}
                                                </div>
                                            </div>
                                        </div>
                                            <div class=\"form-group\">
                                                <div class=\"controls\">
                                                    <label>Total</label>
                                                    {{ form_widget(form.total,{ 'label':'','id':'user-password','attr':{'class':'form-control col-12 col-sm-7 ','placeholder':'total *'}}) }}
                                                    <div class=\"alert alert-danger\">
                                                        {{ form_errors(form.total) }}
                                                    </div>
                                                </div>
                                            </div>
                                         
                                       


                                            <div class=\"col-md-offset-5\" > <button type=\"submit\" href=\"{{path('panier_new')}}\" class=\"btn btn-primary mt30 btn-black \"/>click to save </button> </div>
                                            {{ form_end(form) }}



                                        </div>
                                    </div>


                                </div>


                                <div class=\"tab-pane\" id=\"information\" aria-labelledby=\"information-tab\" role=\"tabpanel\">
                                    <!-- users edit Info form start -->
                                    <form novalidate>
                                        <div class=\"row mt-1\">
                                            <div class=\"col-12 col-sm-6\">
                                                <h5 class=\"mb-1\"><i class=\"feather icon-user mr-25\"></i>Personal Information</h5>
                                                <div class=\"row\">
                                                    <div class=\"col-12\">
                                                        <div class=\"form-group\">
                                                            <div class=\"controls\">
                                                                <label>Birth date</label>
                                                                <input type=\"text\" class=\"form-control birthdate-picker\" required placeholder=\"Birth date\" data-validation-required-message=\"This birthdate field is required\">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class=\"form-group\">
                                                    <div class=\"controls\">
                                                        <label>Mobile</label>
                                                        <input type=\"text\" class=\"form-control\" value=\"&#43;6595895857\" placeholder=\"Mobile number here...\" data-validation-required-message=\"This mobile number is required\">
                                                    </div>
                                                </div>

                                                <div class=\"form-group\">
                                                    <div class=\"controls\">
                                                        <label>Website</label>
                                                        <input type=\"text\" class=\"form-control\" required placeholder=\"Website here...\" value=\"https://rowboat.com/insititious/Angelo\" data-validation-required-message=\"This Website field is required\">
                                                    </div>
                                                </div>
                                                <div class=\"form-group\">
                                                    <label>Languages</label>
                                                    <select class=\"form-control\" id=\"users-language-select2\" multiple=\"multiple\">
                                                        <option value=\"English\" selected>English</option>
                                                        <option value=\"Spanish\">Spanish</option>
                                                        <option value=\"French\">French</option>
                                                        <option value=\"Russian\">Russian</option>
                                                        <option value=\"German\">German</option>
                                                        <option value=\"Arabic\" selected>Arabic</option>
                                                        <option value=\"Sanskrit\">Sanskrit</option>
                                                    </select>
                                                </div>
                                                <div class=\"form-group\">
                                                    <label>Gender</label>
                                                    <ul class=\"list-unstyled mb-0\">
                                                        <li class=\"d-inline-block mr-2\">
                                                            <fieldset>
                                                                <div class=\"vs-radio-con\">
                                                                    <input type=\"radio\" name=\"vueradio\" checked value=\"false\">
                                                                    <span class=\"vs-radio\">
                                                                            <span class=\"vs-radio--border\"></span>
                                                                            <span class=\"vs-radio--circle\"></span>
                                                                        </span>
                                                                    Male
                                                                </div>
                                                            </fieldset>
                                                        </li>
                                                        <li class=\"d-inline-block mr-2\">
                                                            <fieldset>
                                                                <div class=\"vs-radio-con\">
                                                                    <input type=\"radio\" name=\"vueradio\" value=\"false\">
                                                                    <span class=\"vs-radio\">
                                                                            <span class=\"vs-radio--border\"></span>
                                                                            <span class=\"vs-radio--circle\"></span>
                                                                        </span>
                                                                    Female
                                                                </div>
                                                            </fieldset>
                                                        </li>
                                                        <li class=\"d-inline-block mr-2\">
                                                            <fieldset>
                                                                <div class=\"vs-radio-con\">
                                                                    <input type=\"radio\" name=\"vueradio\" value=\"false\">
                                                                    <span class=\"vs-radio\">
                                                                            <span class=\"vs-radio--border\"></span>
                                                                            <span class=\"vs-radio--circle\"></span>
                                                                        </span>
                                                                    Other
                                                                </div>
                                                            </fieldset>
                                                        </li>

                                                    </ul>
                                                </div>
                                                <div class=\"form-group\">
                                                    <label>Contact Options</label>
                                                    <ul class=\"list-unstyled mb-0\">
                                                        <li class=\"d-inline-block mr-2\">
                                                            <fieldset>
                                                                <div class=\"custom-control custom-checkbox\">
                                                                    <input type=\"checkbox\" class=\"custom-control-input\" checked name=\"customCheck1\" id=\"customCheck1\">
                                                                    <label class=\"custom-control-label\" for=\"customCheck1\">Email</label>
                                                                </div>
                                                            </fieldset>
                                                        </li>
                                                        <li class=\"d-inline-block mr-2\">
                                                            <fieldset>
                                                                <div class=\"custom-control custom-checkbox\">
                                                                    <input type=\"checkbox\" class=\"custom-control-input\" checked name=\"customCheck2\" id=\"customCheck2\">
                                                                    <label class=\"custom-control-label\" for=\"customCheck2\">Message</label>
                                                                </div>
                                                            </fieldset>
                                                        </li>
                                                        <li class=\"d-inline-block mr-2\">
                                                            <fieldset>
                                                                <div class=\"custom-control custom-checkbox\">
                                                                    <input type=\"checkbox\" class=\"custom-control-input\" name=\"customCheck3\" id=\"customCheck3\">
                                                                    <label class=\"custom-control-label\" for=\"customCheck3\">Phone</label>
                                                                </div>
                                                            </fieldset>
                                                        </li>
                                                    </ul>
                                                </div>

                                            </div>
                                            <div class=\"col-12 col-sm-6\">
                                                <h5 class=\"mb-1 mt-2 mt-sm-0\"><i class=\"feather icon-map-pin mr-25\"></i>Address</h5>
                                                <div class=\"form-group\">
                                                    <div class=\"controls\">
                                                        <label>Address Line 1</label>
                                                        <input type=\"text\" class=\"form-control\" value=\"A-65, Belvedere Streets\" required placeholder=\"Address Line 1\" data-validation-required-message=\"This Address field is required\">
                                                    </div>
                                                </div>
                                                <div class=\"form-group\">
                                                    <div class=\"controls\">
                                                        <label>Address Line 2</label>
                                                        <input type=\"text\" class=\"form-control\" required placeholder=\"Address Line 2\" data-validation-required-message=\"This Address field is required\">
                                                    </div>
                                                </div>
                                                <div class=\"form-group\">
                                                    <div class=\"controls\">
                                                        <label>Postcode</label>
                                                        <input type=\"text\" class=\"form-control\" required placeholder=\"postcode\" value=\"1868\" data-validation-required-message=\"This Postcode field is required\">
                                                    </div>
                                                </div>
                                                <div class=\"form-group\">
                                                    <div class=\"controls\">
                                                        <label>City</label>
                                                        <input type=\"text\" class=\"form-control\" required value=\"New York\" data-validation-required-message=\"This Time Zone field is required\">
                                                    </div>
                                                </div>
                                                <div class=\"form-group\">
                                                    <div class=\"controls\">
                                                        <label>State</label>
                                                        <input type=\"text\" class=\"form-control\" required value=\"New York\" data-validation-required-message=\"This Time Zone field is required\">
                                                    </div>
                                                </div>
                                                <div class=\"form-group\">
                                                    <div class=\"controls\">
                                                        <label>Country</label>
                                                        <input type=\"text\" class=\"form-control\" required value=\"United Kingdom\" data-validation-required-message=\"This Time Zone field is required\">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class=\"col-12 d-flex flex-sm-row flex-column justify-content-end mt-1\">
                                                <button type=\"submit\" class=\"btn btn-primary glow mb-1 mb-sm-0 mr-0 mr-sm-1\">Save
                                                    Changes</button>
                                                <button type=\"reset\" class=\"btn btn-outline-warning\">Reset</button>
                                            </div>
                                        </div>
                                    </form>
                                    <!-- users edit Info form ends -->
                                </div>
                                <div class=\"tab-pane\" id=\"social\" aria-labelledby=\"social-tab\" role=\"tabpanel\">
                                    <!-- users edit socail form start -->
                                    <form novalidate>
                                        <div class=\"row\">
                                            <div class=\"col-12 col-sm-6\">

                                                <fieldset>
                                                    <label>Twitter</label>
                                                    <div class=\"input-group mb-75\">
                                                        <div class=\"input-group-prepend\">
                                                            <span class=\"input-group-text feather icon-twitter\" id=\"basic-addon3\"></span>
                                                        </div>
                                                        <input type=\"text\" class=\"form-control\" value=\"https://www.twitter.com/adoptionism744\" placeholder=\"https://www.twitter.com/\" aria-describedby=\"basic-addon3\">
                                                    </div>

                                                    <label>Facebook</label>
                                                    <div class=\"input-group mb-75\">
                                                        <div class=\"input-group-prepend\">
                                                            <span class=\"input-group-text feather icon-facebook\" id=\"basic-addon4\"></span>
                                                        </div>
                                                        <input type=\"text\" class=\"form-control\" value=\"https://www.facebook.com/adoptionism664\" placeholder=\"https://www.facebook.com/\" aria-describedby=\"basic-addon4\">
                                                    </div>
                                                    <label>Instagram</label>
                                                    <div class=\"input-group mb-75\">
                                                        <div class=\"input-group-prepend\">
                                                            <span class=\"input-group-text feather icon-instagram\" id=\"basic-addon5\"></span>
                                                        </div>
                                                        <input type=\"text\" class=\"form-control\" value=\"https://www.instagram.com/adopt-ionism744\" placeholder=\"https://www.instagram.com/\" aria-describedby=\"basic-addon5\">
                                                    </div>
                                                </fieldset>
                                            </div>
                                            <div class=\"col-12 col-sm-6\">
                                                <label>Github</label>
                                                <div class=\"input-group mb-75\">
                                                    <div class=\"input-group-prepend\">
                                                        <span class=\"input-group-text feather icon-github\" id=\"basic-addon9\"></span>
                                                    </div>
                                                    <input type=\"text\" class=\"form-control\" value=\"https://www.github.com/madop818\" placeholder=\"https://www.github.com/\" aria-describedby=\"basic-addon9\">
                                                </div>
                                                <label>Codepen</label>
                                                <div class=\"input-group mb-75\">
                                                    <div class=\"input-group-prepend\">
                                                        <span class=\"input-group-text feather icon-codepen\" id=\"basic-addon12\"></span>
                                                    </div>
                                                    <input type=\"text\" class=\"form-control\" value=\"https://www.codepen.com/adoptism243\" placeholder=\"https://www.codepen.com/\" aria-describedby=\"basic-addon12\">
                                                </div>
                                                <label>Slack</label>
                                                <div class=\"input-group mb-75\">
                                                    <div class=\"input-group-prepend\">
                                                        <span class=\"input-group-text feather icon-slack\" id=\"basic-addon11\"></span>
                                                    </div>
                                                    <input type=\"text\" class=\"form-control\" value=\"@adoptionism744\" placeholder=\"https://www.slack.com/\" aria-describedby=\"basic-addon11\">
                                                </div>
                                            </div>
                                            <div class=\"col-12 d-flex flex-sm-row flex-column justify-content-end mt-1\">
                                                <button type=\"submit\" class=\"btn btn-primary glow mb-1 mb-sm-0 mr-0 mr-sm-1\">Save
                                                    Changes</button>
                                                <button type=\"reset\" class=\"btn btn-outline-warning\">Reset</button>
                                            </div>
                                        </div>
                                    </form>
                                    <!-- users edit socail form ends -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        















", "panier/_form.html.twig", "C:\\xampp\\htdocs\\panier\\templates\\panier\\_form.html.twig");
    }
}
